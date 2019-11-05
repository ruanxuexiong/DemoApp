package com.example.demo.app.activity.view;

import com.example.demo.app.mvp.base.MvpView;
import com.longer.service.response.BaseResult;


public interface CallBackView extends MvpView {


    void loginSuccess(BaseResult result, boolean isFirst);

    void loginFail();

    void loginException();
}
