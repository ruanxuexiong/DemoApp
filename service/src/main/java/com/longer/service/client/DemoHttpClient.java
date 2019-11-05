package com.longer.service.client;

import android.app.Application;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by mingjun on 16/7/20.
 */
public class DemoHttpClient extends CacheHttpClient {



    public DemoHttpClient(Application application) {
        super(application);
    }

    @Override
    public OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
        builder = super.customize(builder);
        return builder;
    }
}
