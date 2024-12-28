package io.openim.android.demo;

import java.util.Locale;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import java.util.Locale;

public class MobileNumberUtil {
    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
    private static PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();
    private static String LANGUAGE ="CN";

    //获取手机号码归属地
    public static String getGeo(String phoneNumber){
        if(phoneNumber.length()>10){
            Phonenumber.PhoneNumber referencePhonenumber = null;
            try {
                referencePhonenumber = phoneNumberUtil.parse(phoneNumber, LANGUAGE);
            } catch (NumberParseException e) {
                e.printStackTrace();
            }
            //手机号码归属城市 referenceRegion
            return geocoder.getDescriptionForNumber(referencePhonenumber, Locale.CHINA);
        }
        return "未知地区";

    }
}
