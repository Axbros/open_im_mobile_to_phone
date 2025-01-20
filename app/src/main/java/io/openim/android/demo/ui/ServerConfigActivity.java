package io.openim.android.demo.ui;

import androidx.lifecycle.MutableLiveData;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import io.openim.android.demo.R;
import io.openim.android.demo.SplashActivity;
import io.openim.android.demo.databinding.ActivityServerConfigBinding;
import io.openim.android.ouicore.base.BaseActivity;
import io.openim.android.ouicore.base.BaseApp;
import io.openim.android.ouicore.base.BaseViewModel;
import io.openim.android.ouicore.utils.Common;
import io.openim.android.ouicore.utils.Constants;
import io.openim.android.ouicore.utils.SharedPreferencesUtil;
import io.openim.android.ouicore.widget.WaitDialog;

public class ServerConfigActivity extends BaseActivity<BaseViewModel, ActivityServerConfigBinding> {

    private final ServerConfigVM serverConfigVM = new ServerConfigVM();
    private boolean isIP = Constants.getIsIp();
    private boolean isFirst = true;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch switchControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViewDataBinding(ActivityServerConfigBinding.inflate(getLayoutInflater()));
        sink();
        view.setServerConfigVM(serverConfigVM);
        view.restart.setOnClickListener(v -> {
            if (!serverConfigVM.HEAD.getValue().equals(Constants.getHostURL()))
                SharedPreferencesUtil.get(BaseApp.inst()).setCache("DEFAULT_HOST_URL",
                    serverConfigVM.HEAD.getValue());

            if (!serverConfigVM.IM_API_URL.getValue().equals(Constants.getImApiUrl()))
                SharedPreferencesUtil.get(BaseApp.inst()).setCache("IM_API_URL",
                    serverConfigVM.IM_API_URL.getValue());

            if (!serverConfigVM.APP_AUTH_URL.getValue().equals(Constants.getAppAuthUrl())) {
                String appAuthUrl = serverConfigVM.APP_AUTH_URL.getValue();
                if (!appAuthUrl.endsWith("/")) {
                    appAuthUrl += "/";
                }
                SharedPreferencesUtil.get(BaseApp.inst()).setCache("APP_AUTH_URL", appAuthUrl);
            }
            if (!serverConfigVM.IM_WS_URL.getValue().equals(Constants.getImWsUrl()))
                SharedPreferencesUtil.get(BaseApp.inst()).setCache("IM_WS_URL",
                    serverConfigVM.IM_WS_URL.getValue());
            if (!serverConfigVM.STORAGE_TYPE.getValue().equals(Constants.getStorageType()))
                SharedPreferencesUtil.get(BaseApp.inst()).setCache("STORAGE_TYPE",
                    serverConfigVM.STORAGE_TYPE.getValue());
//            if(!serverConfigVM.PARENT_UID.getValue().equals(Constants.getParentUID()))
//                SharedPreferencesUtil.get(BaseApp.inst()).setCache("PARENT_UID",
//                    serverConfigVM.PARENT_UID.getValue());
            if(!serverConfigVM.IS_ADMIN.getValue()==Constants.getIsAdmin())
                SharedPreferencesUtil.get(BaseApp.inst()).setCache("isAdmin",
                    serverConfigVM.IS_ADMIN.getValue());

            WaitDialog waitDialog = new WaitDialog(this);
            waitDialog.setNotDismiss();
            waitDialog.show();
            Common.UIHandler.postDelayed(this::restart, 1000);

            switchControl = findViewById(R.id.switch_control);
            switchControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    editTextParentUid.setEnabled(isChecked);
                    // 这里可以添加更多根据开关状态变化要执行的逻辑，比如改变文本颜色等
                    System.out.println("检测到用户权限发生变化"+isChecked);
                }
            });

        });

        view.swDomain.setOnClickListener(v -> {
            isIP = false;
            view.head.setText("域名");
            SharedPreferencesUtil.get(BaseApp.inst()).setCache("IS_IP", isIP);
            serverConfigVM.HEAD.setValue(Constants.DEFAULT_HOST_URL);
        });
        view.swIP.setOnClickListener(v -> {
            isIP = true;
            view.head.setText("IP");
            SharedPreferencesUtil.get(BaseApp.inst()).setCache("IS_IP", isIP);
            serverConfigVM.HEAD.setValue(Constants.DEFAULT_HOST);
        });
        view.switchControl.setOnCheckedChangeListener((v,isChecked) ->{
           SharedPreferencesUtil.get(BaseApp.inst()).setCache("isAdmin",isChecked);
           serverConfigVM.IS_ADMIN.setValue(isChecked);
        });

        serverConfigVM.HEAD.observe(this, s -> {
            if (isFirst) {
                isFirst = false;
                return;
            }

                setAddress(
                    "http://" + s + "/api",
                    "http://" + s + "/chat/",
                    "ws://" + s + "/msg_gateway");

        });
    }

    private void setAddress(String s, String s2, String s3) {
        serverConfigVM.IM_API_URL.setValue(s);
        serverConfigVM.APP_AUTH_URL.setValue(s2);
        serverConfigVM.IM_WS_URL.setValue(s3);

    }


    private void restart() {
        Intent intent = new Intent(BaseApp.inst(), SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        BaseApp.inst().startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static class ServerConfigVM {
        public MutableLiveData<String> HEAD = new MutableLiveData<>(Constants.getHostURL());
        public MutableLiveData<String> IM_API_URL = new MutableLiveData<>(Constants.getImApiUrl());
        public MutableLiveData<String> APP_AUTH_URL =
            new MutableLiveData<>(Constants.getAppAuthUrl());
        public MutableLiveData<String> IM_WS_URL = new MutableLiveData<>(Constants.getImWsUrl());
        public MutableLiveData<String> STORAGE_TYPE =
            new MutableLiveData<>(Constants.getStorageType());
//        public MutableLiveData<String> PARENT_UID=new MutableLiveData<>(Constants.getParentUID());
        public MutableLiveData<Boolean> IS_ADMIN =new MutableLiveData<>(Constants.getIsAdmin());

    }
}
