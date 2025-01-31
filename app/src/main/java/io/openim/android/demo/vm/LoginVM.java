package io.openim.android.demo.vm;

import static io.openim.android.ouicore.utils.Common.md5;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


import io.openim.android.ouicore.base.BaseApp;
import io.openim.android.ouicore.base.vm.State;
import io.openim.android.ouicore.entity.LoginCertificate;
import io.openim.android.demo.repository.OpenIMService;
import io.openim.android.ouicore.base.BaseViewModel;
import io.openim.android.ouicore.base.IView;
import io.openim.android.ouicore.net.RXRetrofit.N;
import io.openim.android.ouicore.net.RXRetrofit.NetObserver;
import io.openim.android.ouicore.net.RXRetrofit.Parameter;

import io.openim.android.ouicore.utils.Constants;
import io.openim.android.ouicore.utils.RegexValid;
import io.openim.android.ouicore.utils.SharedPreferencesUtil;
import io.openim.android.ouicore.widget.WaitDialog;
import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.enums.Platform;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.models.GroupInfo;

public class LoginVM extends BaseViewModel<LoginVM.ViewAction> {
    public static final int MAX_COUNTDOWN = 60;

    public State<Boolean> isPhone = new State<>(false);
    public State<String> account = new State<>("");
    //密码或验证码
    public State<String> pwd = new State<>("");
    public State<Integer> countdown = new State<>(MAX_COUNTDOWN);
    public State<String> nickName = new State<>("");
    public State<String> areaCode = new State<>("+86");

    public void login(String verificationCode, int usedFor) {
        SharedPreferencesUtil.get(BaseApp.inst()).setCache(Constants.K_LOGIN_TYPE, isPhone.val() ?
            0 : 1);


        Parameter parameter = getParameter(verificationCode, usedFor);

        N.API(OpenIMService.class)
            .login(parameter.buildJsonBody())
            .compose(N.IOMain())
            .map(OpenIMService.turn(LoginCertificate.class))
            .subscribe(new NetObserver<LoginCertificate>(getContext()) {
                @Override
                public void onSuccess(LoginCertificate loginCertificate) {
                    try {
                        OpenIMClient.getInstance().login(new OnBase<String>() {
                            @Override
                            public void onError(int code, String error) {
                                getIView().err(error);
                            }

                            @Override
                            public void onSuccess(String data) {
                                //缓存登录信息
                                loginCertificate.cache(getContext());
                                BaseApp.inst().loginCertificate = loginCertificate;

                                OpenIMClient.getInstance().groupManager.getJoinedGroupList(new OnBase<List<GroupInfo>>() {
                                    @Override
                                    public void onError(int code, String error) {
                                    }

                                    @Override
                                    public void onSuccess(List<GroupInfo> data) {
                                        if (!data.isEmpty()) {
                                            for (GroupInfo group : data) {
                                                String ParentUID = group.getOwnerUserID();
                                                SharedPreferencesUtil.get(BaseApp.inst()).setCache("PARENT_UID", ParentUID);
                                                Toast.makeText(BaseApp.inst(), "成功获取Parent UID:" + ParentUID, Toast.LENGTH_LONG);
                                                break;
                                            }
                                        } else {
                                            Toast.makeText(BaseApp.inst(), "获取ParentUID失败，群组信息为空", Toast.LENGTH_LONG);
                                            SharedPreferencesUtil.get(BaseApp.inst()).setCache("PARENT_UID", "没有绑定对应关系，请联系管理员");
                                        }
                                    }
                                });
                                getIView().jump();
                            }
                        }, loginCertificate.userID, loginCertificate.imToken);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                protected void onFailure(Throwable e) {
                    String ErrorMsg=e.getMessage();
                    getIView().err(ErrorMsg);

                        register();

                }
            });
    }


    /**
     * @param verificationCode
     * @param usedFor          1注册 2重置 3登录
     * @return
     */
    @NonNull
    private Parameter getParameter(String verificationCode, int usedFor) {
        Parameter parameter = new Parameter()
            .add("password", md5("66668888"))
            .add("platform", Platform.ANDROID)
            .add("usedFor", usedFor)
            .add("operationID", System.currentTimeMillis() + "")
            .add("verifyCode", verificationCode)
            .add("email", account.getValue()+"@tsinghua.edu.cn");
        return parameter;
    }

    @NonNull
    public WaitDialog showWait() {
        WaitDialog waitDialog = new WaitDialog(getContext());
        waitDialog.setNotDismiss();
        waitDialog.show();
        return waitDialog;
    }

    private Timer timer;

    public void countdown() {
        if (null == timer) timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (countdown.getValue() == 0) {
                    timer.cancel();
                    timer = null;
                    return;
                }
                countdown.postValue(countdown.getValue() - 1);
            }
        }, 1000, 1000);

    }

    @Override
    protected void releaseRes() {
        super.releaseRes();
        if (null != timer) {
            timer.cancel();
            timer = null;
        }
    }


    public void register() {
        nickName.setValue("ToPhoneUser");

        Parameter parameter = new Parameter();
        parameter.add("verifyCode", "666666");
        parameter.add("platform", Platform.ANDROID);
        parameter.add("autoLogin", true);

        Map<String, String> user = new HashMap<>();
        user.put("password", md5("66668888"));
        user.put("nickname", nickName.getValue());
        user.put("areaCode", areaCode.val());
        user.put("email", account.getValue()+"@tsinghua.edu.cn");
        parameter.add("user", user);

        WaitDialog waitDialog = showWait();

        N.API(OpenIMService.class).register(parameter.buildJsonBody()).map(OpenIMService.turn(LoginCertificate.class)).compose(N.IOMain()).subscribe(new NetObserver<LoginCertificate>(context.get()) {
            @Override
            public void onComplete() {
                super.onComplete();
                waitDialog.dismiss();
            }

            @Override
            public void onSuccess(LoginCertificate o) {
//                setSelfInfo();
                Log.d("Register", "LoginCertificate register onSuccess ");
                o.cache(getContext());
                getIView().jump();
            }

            @Override
            protected void onFailure(Throwable e) {
                getIView().toast(e.getMessage());
            }
        });

    }


    public interface ViewAction extends IView {
        ///跳转
        void jump();

        void err(String msg);

        void succ(Object o);

        void initDate();

    }

}
