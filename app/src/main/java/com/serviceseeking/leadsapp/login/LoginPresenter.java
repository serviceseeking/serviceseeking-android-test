package com.serviceseeking.leadsapp.login;


import android.text.TextUtils;

import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.models.Session;
import com.serviceseeking.leadsapp.remote.CallbackWrapper;
import com.serviceseeking.leadsapp.remote.ReachPrimeService;
import com.serviceseeking.leadsapp.remote.requests.Attributes;
import com.serviceseeking.leadsapp.remote.requests.Data;
import com.serviceseeking.leadsapp.remote.requests.LoginRequest;
import com.serviceseeking.leadsapp.remote.responses.CommonResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter {

    private LoginView mView;
    private Session session;

    LoginPresenter(LoginView view) {
        mView = view;
        session = new Session(view.getContext());
    }

    public void startServerLogin(final String email, String password) {
        mView.showProgressDialog(null, "Loading ...");

        LoginRequest request = createLoginRequest(email, password);
        ReachPrimeService.getClient().loginUser(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CallbackWrapper<CommonResponse>(mView.getContext()) {
                    @Override
                    protected void onSuccess(CommonResponse response) {
                        mView.dismissProgressDialog();
                        session.authorize(email, response.getMeta().getToken());
                        session.saveUser(response.getData());
                        mView.showAlertDialog(mView.getContext().getString(R.string.success), mView.getContext().getString(R.string.success_login), true);
                    }

                    @Override
                    protected void onFailed(String errorMessage) {
                        mView.dismissProgressDialog();
                        mView.showAlertDialog(mView.getContext().getString(R.string.failed), errorMessage, false);
                    }
                });

    }

    private LoginRequest createLoginRequest(String email, String password) {
        Attributes attributes = new Attributes();
        attributes.setEmail(email);
        attributes.setPassword(password);

        Data data = new Data();
        data.setAttributes(attributes);
        data.setType("user_sessions");

        LoginRequest request = new LoginRequest();
        request.setData(data);
        return request;
    }


    public void openActivity() {
        mView.loadActivity();
    }

    public boolean isEmailValid(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public void checkFields(String email, String password) {
        String msg = mView.validateInputs();
        if (msg.equals("")) {
            startServerLogin(email, password);
        } else {
            mView.showAlertDialog(mView.getContext().getString(R.string.failed), msg, false);
        }
    }
}
