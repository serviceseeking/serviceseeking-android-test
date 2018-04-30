package com.serviceseeking.leadsapp.login;

import android.content.Context;

public interface LoginView {

    void showProgressDialog(String title, String message);

    void showAlertDialog(String title, String message, boolean isRedirect);

    void dismissProgressDialog();

    void loadActivity();

    String validateInputs();

    Context getContext();
}
