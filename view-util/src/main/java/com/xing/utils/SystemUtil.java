package com.xing.utils;

/**
 * Created by lenovo on 2017/7/31.
 */

public class SystemUtil {


    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }
}
