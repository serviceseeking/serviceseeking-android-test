package com.serviceseeking.leadsapp.lead_list;

import android.content.Context;

import com.serviceseeking.leadsapp.remote.responses.Data;

import java.util.List;

public interface LeadListView {

    void showProgressDialog(String title, String message);

    void showAlertDialog(String title, String message);

    void dismissProgressDialog();

    void populateLeads(List<Data> arrayOfUsers);

    void loadActivity(Class<?> clazz);

    Context getContext();
}
