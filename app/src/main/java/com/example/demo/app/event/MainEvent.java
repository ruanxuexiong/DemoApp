package com.example.demo.app.event;

public class MainEvent {
    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public MainEvent(boolean isLogin) {
        this.isLogin = isLogin;
    }
}
