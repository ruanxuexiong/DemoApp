package com.example.demo.app.mvp;

import android.app.Application;

import com.longer.service.api.MainApi;
import com.longer.service.client.DemoHttpClient;
import com.longer.service.client.DemoRetrofit;

public class MainRetrofit {
    private static MainApi mainApi;

    public static MainApi getInstance(Application application) {
        if (mainApi == null) {
            DemoRetrofit demoRetrofit = new DemoRetrofit(new DemoHttpClient(application));
            mainApi = demoRetrofit.get().create(MainApi.class);
        }
        return mainApi;
    }

}
