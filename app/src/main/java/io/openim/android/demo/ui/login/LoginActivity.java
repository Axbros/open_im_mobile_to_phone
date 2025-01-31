package io.openim.android.demo.ui.login;

import android.content.Intent;
import io.openim.android.demo.ui.ServerConfigActivity;
import io.openim.android.demo.ui.main.MainActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;


import androidx.annotation.NonNull;

import com.hbb20.CountryCodePicker;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import io.openim.android.demo.databinding.ActivityLoginBinding;
import io.openim.android.demo.vm.LoginVM;
import io.openim.android.ouicore.base.BaseActivity;
import io.openim.android.ouicore.base.BaseApp;
import io.openim.android.ouicore.utils.Common;
import io.openim.android.ouicore.utils.Constants;
import io.openim.android.ouicore.utils.LanguageUtil;
import io.openim.android.ouicore.utils.SharedPreferencesUtil;
import io.openim.android.ouicore.utils.SinkHelper;
import io.openim.android.ouicore.widget.WaitDialog;
import android.content.Context;
import android.provider.Settings;


public class LoginActivity extends BaseActivity<LoginVM, ActivityLoginBinding> implements LoginVM.ViewAction {

    public static final String FORM_LOGIN = "form_login";
    private WaitDialog waitDialog;
    //是否是验证码登录
    private boolean isVCLogin = false;
    private Timer timer;
    //验证码倒计时
    private int countdown = 60;

    private String AndroidID = "";

    public String setAndroidId(Context context) {
        this.AndroidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return this.AndroidID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApp.inst().removeCacheVM(LoginVM.class);
        bindVM(LoginVM.class, true);
        bindViewDataBinding(ActivityLoginBinding.inflate(getLayoutInflater()));
        setLightStatus();
        SinkHelper.get(this).setTranslucentStatus(null);
        setAndroidId(this);

        initView();

        click();
        //获取设备唯一标识码
        //通过唯一标识码注册
        //如果
    }

    void initView() {
        waitDialog = new WaitDialog(this);
        view.loginContent.setLoginVM(vm);
        view.setLoginVM(vm);
        view.version.setText("ToPhone App Version "+Common.getAppPackageInfo().versionName);

        view.loginContent.edt1.setEnabled(false);
        view.loginContent.edt1.setText(this.AndroidID);
        vm.account.setValue(this.AndroidID);
        System.out.println();
        vm.isPhone.setValue(SharedPreferencesUtil.get(this).getInteger(Constants.K_LOGIN_TYPE) == 0);
    }

    public static CountryCodePicker.Language buildDefaultLanguage() {
        Locale locale = LanguageUtil.getCurrentLocale(BaseApp.inst());
        CountryCodePicker.Language language;
        if (locale.getLanguage().equals(Locale.CHINA.getLanguage()))
            language = CountryCodePicker.Language.CHINESE_SIMPLIFIED;
        else language = CountryCodePicker.Language.forCountryNameCode(locale.getLanguage());
        return language;
    }


    private final GestureDetector gestureDetector = new GestureDetector(BaseApp.inst(),
        new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                startActivity(new Intent(LoginActivity.this, ServerConfigActivity.class));
                return super.onDoubleTap(e);
            }
        });

    private void click() {
        view.submit.setOnClickListener(v -> {
            waitDialog.show();
            vm.login(isVCLogin ? vm.pwd.getValue() : null, 3);
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void jump() {
        startActivity(new Intent(this, MainActivity.class).putExtra(FORM_LOGIN, true));
        waitDialog.dismiss();
        finish();
    }

    @Override
    public void err(String msg) {
        waitDialog.dismiss();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void succ(Object o) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                countdown--;
//                runOnUiThread(new TimerTask() {
//                    @Override
//                    public void run() {
//                        view.loginContent.getVC.setText(countdown + "s");
//                    }
//                });

                if (countdown <= 0) {
//                    view.loginContent.getVC.setText(io.openim.android.ouicore.R.string.get_vc);
                    countdown = 60;
                    timer.cancel();
                    timer = null;
                }
            }
        }, 0, 1000);
    }

    @Override
    public void initDate() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != timer) {
            timer.cancel();
            timer = null;
        }
    }
}
