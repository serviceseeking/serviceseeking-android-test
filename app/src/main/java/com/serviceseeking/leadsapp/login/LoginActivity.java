package com.serviceseeking.leadsapp.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.serviceseeking.leadsapp.BaseActivity;
import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.lead_list.LeadListActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindString(R.string.invalid_email)
    String invalidEmail;

    @BindString(R.string.enter_email)
    String enterEmail;

    @BindString(R.string.enter_pass)
    String enterPassword;

    @BindString(R.string.login)
    String login;

    @BindString(R.string.ok)
    String ok;


    private ProgressDialog pDialog;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        tvTitle.setText(login);
        tvLogout.setVisibility(View.GONE);

        btnLogin.setOnClickListener(this);
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.checkFields(etEmail.getText().toString(), etPassword.getText().toString());
                break;
        }
    }

    @Override
    public void showProgressDialog(String title, String message) {
        pDialog = ProgressDialog.show(this, title, message);
    }

    @Override
    public void showAlertDialog(String title, String message, final boolean isRedirect) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(LoginActivity.this, android.R.style.Theme_Holo_Light);
        AlertDialog alertDialog = new AlertDialog.Builder(contextThemeWrapper).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (isRedirect) {
                    mPresenter.openActivity();
                }
            }
        });
        alertDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    @Override
    public String validateInputs() {
        if (etEmail.getText().toString().equals("")) {
            return enterEmail;
        } else if (etPassword.getText().toString().equals("")) {
            return enterPassword;
        } else if (!mPresenter.isEmailValid(etEmail.getText().toString())) {
            return invalidEmail;
        }
        return "";
    }

    @Override
    public void loadActivity() {
        finish();
        startActivity(new Intent(LoginActivity.this, LeadListActivity.class));
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
