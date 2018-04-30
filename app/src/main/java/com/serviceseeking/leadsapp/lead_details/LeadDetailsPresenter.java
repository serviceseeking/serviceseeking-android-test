package com.serviceseeking.leadsapp.lead_details;


import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.models.Session;
import com.serviceseeking.leadsapp.remote.CallbackWrapper;
import com.serviceseeking.leadsapp.remote.ReachPrimeService;
import com.serviceseeking.leadsapp.remote.responses.CommonResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LeadDetailsPresenter {

    private LeadDetailsView mView;

    LeadDetailsPresenter(LeadDetailsView view) {
        mView = view;
    }

    public void startServerGetLeadDetail(String leadId) {
        mView.showProgressDialog(null, "Loading ...");
        ReachPrimeService.getClient().getLeadResponse("Basic c3NzdGFnaW5nOnNzVDNzdDFuZyE=, Token token=" +
                Session.TOKEN, leadId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CallbackWrapper<CommonResponse>(mView.getContext()) {
                    @Override
                    protected void onSuccess(CommonResponse response) {
                        mView.dismissProgressDialog();
                        mView.populateData(response);
                    }

                    @Override
                    protected void onFailed(String errorMessage) {
                        mView.dismissProgressDialog();
                        mView.showAlertDialog(mView.getContext().getString(R.string.failed), errorMessage);
                    }
                });

    }
}
