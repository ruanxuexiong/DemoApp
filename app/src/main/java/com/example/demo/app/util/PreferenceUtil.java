package com.example.demo.app.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class PreferenceUtil {
    private final static String DEMOAPPLICATION = "demoApplication";
    private static SharedPreferences sharedPreferences;
    private static PreferenceUtil preferenceUtil;

    public static PreferenceUtil getInstance(Application application) {
        if (preferenceUtil == null || sharedPreferences == null) {
            preferenceUtil = new PreferenceUtil();
            sharedPreferences = application.getSharedPreferences(DEMOAPPLICATION, Context.MODE_PRIVATE);
        }
        return preferenceUtil;
    }

    public static void clearData() {
        if (sharedPreferences != null)
            sharedPreferences.edit().clear().apply();
    }

    //判断是否登录成功
    public static void saveLogin(boolean isLogin) {
        if (sharedPreferences == null)
            return;
        sharedPreferences.edit().putBoolean("login", isLogin).apply();
    }

    public static boolean getLoginSuccess() {
        if (sharedPreferences == null)
            return false;
        return sharedPreferences.getBoolean("login", false);
    }

    /**
     * 保存数据
     */
    public static void saveCategory(String code, long time) {
        if (sharedPreferences == null)
            return;
        sharedPreferences.edit().putLong(code, time).apply();
    }

    public static long getCategory(String code) {
        if (sharedPreferences == null)
            return 0;
        return sharedPreferences.getLong(code, 0);
    }
}
