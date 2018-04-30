package com.serviceseeking.leadsapp.lead_list;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListView;

import com.serviceseeking.leadsapp.BaseActivity;
import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.adapters.LeadListAdapter;
import com.serviceseeking.leadsapp.remote.responses.Data;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class LeadListActivity extends BaseActivity implements LeadListView, View.OnClickListener {

    public LeadListPresenter mPresenter;
    @BindView(R.id.lvLeads)
    ListView lvLeads;
    @BindView(R.id.pullToRefresh)
    SwipeRefreshLayout pullToRefresh;
    @BindString(R.string.ok)
    String ok;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_list);

        ButterKnife.bind(this);

        tvTitle.setText(R.string.leads);
        tvLogout.setVisibility(View.VISIBLE);
        tvLogout.setOnClickListener(this);

        mPresenter = new LeadListPresenter(this);
        if (mPresenter.session.isAuthorized()) {
            mPresenter.startServerGetAllLeads();
        } else {
            mPresenter.openActivity();
        }

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                mPresenter.startServerGetAllLeads();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_logout:
                mPresenter.logout();
                break;
        }
    }

    @Override
    public void showProgressDialog(String title, String message) {
        pullToRefresh.setRefreshing(false);
        pDialog = ProgressDialog.show(this, title, message);
    }

    @Override
    public void showAlertDialog(String title, String message) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(LeadListActivity.this, android.R.style.Theme_Holo_Light);
        AlertDialog alertDialog = new AlertDialog.Builder(contextThemeWrapper).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
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
    public void loadActivity(Class<?> clazz) {
        finish();
        startActivity(new Intent(LeadListActivity.this, clazz));
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void populateLeads(List<Data> arrayOfUsers) {
        LeadListAdapter adapter = new LeadListAdapter(this, arrayOfUsers);
        lvLeads.setAdapter(adapter);
    }
}
