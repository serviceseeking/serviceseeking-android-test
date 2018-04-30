package com.serviceseeking.leadsapp.lead_list;

import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.login.LoginActivity;
import com.serviceseeking.leadsapp.models.Session;
import com.serviceseeking.leadsapp.remote.CallbackWrapper;
import com.serviceseeking.leadsapp.remote.ReachPrimeService;
import com.serviceseeking.leadsapp.remote.responses.CommonResponse;
import com.serviceseeking.leadsapp.remote.responses.Data;
import com.serviceseeking.leadsapp.remote.responses.ErrorResponse;
import com.serviceseeking.leadsapp.remote.responses.GetLeadsResponse;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class LeadListPresenter {

    public Session session;
    private LeadListView mView;

    LeadListPresenter(LeadListView view) {
        mView = view;
        session = new Session(view.getContext());
    }

    public void startServerGetAllLeads() {
        mView.showProgressDialog(null, "Loading ...");
        ReachPrimeService.getClient().getLeadsResponse("Basic c3NzdGFnaW5nOnNzVDNzdDFuZyE=, Token token=" +
                Session.TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<GetLeadsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(GetLeadsResponse getLeadsResponse) {
                        checkUser(getLeadsResponse);

                    }

                    @Override
                    public void onError(Throwable e) {
                        String error = "";
                        e.printStackTrace();
                        if (e instanceof HttpException) {
                            error = getErrorResponse(((HttpException) e).response());
                        } else if (e instanceof SocketTimeoutException) {
                            error = mView.getContext().getString(R.string.conn_timeout);
                        } else if (e instanceof IOException) {
                            error = e.getMessage();
                            if (error.contains("Unable to resolve host")) {
                                error = mView.getContext().getString(R.string.no_net);
                            }
                        } else {
                            error = mView.getContext().getString(R.string.error);
                        }
                        mView.dismissProgressDialog();
                        mView.showAlertDialog(mView.getContext().getString(R.string.failed), error);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void checkUser(GetLeadsResponse getLeadsResponse) {
        mView.dismissProgressDialog();
        Data currentData = session.retrieveUser();
        List<Data> datas = getLeadsResponse.getDatas();
        boolean isLead = false;
        for (Data data : datas) {
            if (data.getId().equals(currentData.getId())) {
                isLead = true;
                return;
            }
        }
//        if(isLead) {
        mView.populateLeads(getLeadsResponse.getDatas());
//        }
    }

    private String getErrorResponse(Response response) {
        ResponseBody responseBody = response.errorBody();
        String errorMsg = mView.getContext().getString(R.string.error);
        if (responseBody != null) {
            try {
                String error = responseBody.string();
                if (CallbackWrapper.isJsonValid(error)) {
                    CommonResponse commonResponse = new Gson().fromJson(error, CommonResponse.class);
                    if (commonResponse != null) {
                        List<ErrorResponse> commonErrors = commonResponse.getErrors();
                        errorMsg = commonErrors.get(0).getTitle();
                        if (commonErrors.size() > 1) {
                            errorMsg = commonErrors.get(1).getTitle();
                        }
                    }
                } else {
                    errorMsg = response.code() + " " + response.message();
                }
            } catch (IOException e) {
                e.printStackTrace();
                errorMsg = e.getMessage();
            }
        }
        return errorMsg;
    }

    public void openActivity() {
        mView.loadActivity(LoginActivity.class);
    }

    public void logout() {
        session.deAuthorize();
        openActivity();
    }
}
