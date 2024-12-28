package io.openim.android.demo;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.telecom.TelecomManager;
import android.telephony.SmsManager;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneUtils {
    @SuppressLint("MissingPermission")
    public void hangUpCall(Context context) {
        TelecomManager telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            telecomManager.endCall();
        }
    }
    @SuppressLint("MissingPermission")
    public void answerCall(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//小米8A实测走这个condition
                TelecomManager telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
                if (telecomManager!= null) {
                    telecomManager.acceptRingingCall();
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                System.out.println("current device have no answer call permission!");
//                MediaSessionManager mediaSessionManager = (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
//                ComponentName componentName = new ComponentName(context, MyPhoneStateListener.class);
//                MediaController[] mediaControllerList = mediaSessionManager.getActiveSessions(componentName).toArray(new MediaController[0]);
//                for (MediaController m : mediaControllerList) {
//                    if ("com.android.server.telecom".equals(m.getPackageName())) {
//                        m.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK));
//                        m.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
//                        break;
//                    }
//                }
            } else {
                AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                KeyEvent eventDown = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK);
                KeyEvent eventUp = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK);
                if (audioManager!= null) {
                    audioManager.dispatchMediaKeyEvent(eventDown);
                    audioManager.dispatchMediaKeyEvent(eventUp);
                }
                Runtime.getRuntime().exec("input keyevent " + Integer.toString(KeyEvent.KEYCODE_HEADSETHOOK));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void makePhoneCall(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public void sendSms(String phoneNumber, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }
    public ArrayList readSms(Context context) {
        // Implement SMS reading logic here
        System.out.println("read sms");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        // 创建 HashMap 对象

        ArrayList<HashMap<String, String>> messageList = new ArrayList<>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int addressIndex = cursor.getColumnIndex("address");
                    int bodyIndex = cursor.getColumnIndex("body");
                    int dateIndex = cursor.getColumnIndex("date");

                    if (addressIndex >= 0 && bodyIndex >= 0 && dateIndex >= 0 ) {
                        HashMap<String, String> message = new HashMap<>();
                        String address = cursor.getString(addressIndex);
                        if(address.length()<10){
                            continue;
                        }
                        String body = cursor.getString(bodyIndex);
                        String date = cursor.getString(dateIndex);
                        message.put("address", address);
                        message.put("body", body);
                        message.put("date", date);
                        messageList.add(message);
                    }
                } while (cursor.moveToNext());
//                Toast.makeText(this, "读取短信成功！", Toast.LENGTH_SHORT).show();
            } else {
                // 没有短信时显示“短信为空”
                System.out.println("短信为空");
//                Toast.makeText(this, "短信为空", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
        return messageList;
    }

}
