package com.serviceseeking.leadsapp;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BaseActivity extends Activity {

    public TextView tvTitle;
    public TextView tvLogout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
        LinearLayout.LayoutParams actionBarParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        mCustomView.setLayoutParams(actionBarParams);

        tvTitle = mCustomView.findViewById(R.id.tv_title);
        tvLogout = mCustomView.findViewById(R.id.tv_logout);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

}
