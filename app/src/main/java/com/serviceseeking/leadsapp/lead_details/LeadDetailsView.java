package com.serviceseeking.leadsapp.lead_details;

import android.content.Context;

import com.serviceseeking.leadsapp.remote.responses.CommonResponse;

public interface LeadDetailsView {

    void showProgressDialog(String title, String message);

    void showAlertDialog(String title, String message);

    void dismissProgressDialog();

    void populateData(CommonResponse lead);

    Context getContext();
}
