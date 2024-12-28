package io.openim.android.demo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import io.openim.android.ouicore.utils.L;


public class PhoneStateService extends Service {
    private PhoneStateListener phoneStateListener;
    private TelephonyManager telephonyManager;

    public PhoneStateService() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
        phoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                String stateText = String.valueOf(state);
                // L.e("onCallStateChanged", "state: " + state + ", incomingNumber: " + incomingNumber);
                switch (state){
                    case TelephonyManager.CALL_STATE_IDLE:
                        stateText = "idle";
                        L.e("onCallStateChanged", "state: " + state + ", incomingNumber: " + incomingNumber);
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        stateText="income";
                        L.e("onCallStateChanged", "state: " + state + ", incomingNumber: " + incomingNumber);
                        break;
                }
                String location=MobileNumberUtil.getGeo(incomingNumber);
                DemoApplication.sendMessage2Parent(stateText,incomingNumber,location);
            }
        };
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (telephonyManager!= null && phoneStateListener!= null) {
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
        }
    }

}
