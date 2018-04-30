package com.serviceseeking.leadsapp.lead_details;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;

import com.serviceseeking.leadsapp.BaseActivity;
import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.remote.responses.CommonResponse;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class LeadDetailsActivity extends BaseActivity implements LeadDetailsView {

    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_suburb)
    TextView tvSuburb;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindString(R.string.ok)
    String ok;
    private ProgressDialog pDialog;
    private LeadDetailsPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_details);
        ButterKnife.bind(this);

        mPresenter = new LeadDetailsPresenter(this);

        tvTitle.setText(R.string.details);
        tvLogout.setVisibility(View.GONE);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mPresenter.startServerGetLeadDetail(bundle.getString("leadId"));
        }
    }

    @Override
    public void showProgressDialog(String title, String message) {
        pDialog = ProgressDialog.show(this, title, message);
    }

    @Override
    public void showAlertDialog(String title, String message) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(LeadDetailsActivity.this, android.R.style.Theme_Holo_Light);
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
    public void populateData(CommonResponse lead) {
        tvUsername.setText(lead.getData().getAttributes().getUserName());
        tvSuburb.setText(lead.getData().getAttributes().getSuburbName());
        tvDesc.setText(lead.getData().getAttributes().getDescription());
        tvName.setText(lead.getData().getAttributes().getName());
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
