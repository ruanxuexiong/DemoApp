package com.longer.service.client;


import com.longer.service.client.core.ApiEndpoint;
import com.longer.service.client.core.BaseRetrofit;


import okhttp3.OkHttpClient;

/**
 * Created by mingjun on 16/7/27.
 */
public class DemoRetrofit extends BaseRetrofit {

    public static final String END_POINT = "http://baobab.kaiyanapp.com/api/";
//public static final String END_POINT = "https://7mall.hk/";
    DemoHttpClient mHttpClient;

    public DemoRetrofit(DemoHttpClient mHttpClient) {
        this.mHttpClient = mHttpClient;
    }

    @Override
    public ApiEndpoint getApiEndpoint() {
        return new ApiEndpoint() {
            @Override
            public String getEndpoint() {
                return END_POINT;
            }
        };
    }

    @Override
    public OkHttpClient getHttpClient() {
        return mHttpClient.get();
    }
}
