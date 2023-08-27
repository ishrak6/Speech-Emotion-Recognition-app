package com.example.ycfelix.myapplication;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.Manifest;
import android.content.pm.PackageManager;


public class DeviceIdUtil {

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // Handle permission request if not granted.
            return null;
        }

        String imei = telephonyManager.getDeviceId();
        return imei;
    }
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;

        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }
}
