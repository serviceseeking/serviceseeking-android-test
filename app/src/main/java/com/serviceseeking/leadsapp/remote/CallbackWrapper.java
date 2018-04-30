package com.serviceseeking.leadsapp.remote;

import android.content.Context;

import com.serviceseeking.leadsapp.R;
import com.serviceseeking.leadsapp.remote.responses.CommonResponse;
import com.serviceseeking.leadsapp.remote.responses.ErrorResponse;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.Response;


public abstract class CallbackWrapper<T extends CommonResponse> extends DisposableObserver<T> {

    private Context context;

    public CallbackWrapper(Context context) {
        this.context = context;
    }

    public static boolean isJsonValid(String string) {
        try {
            new JSONObject(string);
        } catch (JSONException ex) {
            try {
                new JSONArray(string);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFailed(String errorMessage);

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        String error = "";
        e.printStackTrace();
        if (e instanceof HttpException) {
            error = getErrorResponse(((HttpException) e).response());
        } else if (e instanceof SocketTimeoutException) {
            error = context.getString(R.string.conn_timeout);
        } else if (e instanceof IOException) {
            error = e.getMessage();
            if (error.contains("Unable to resolve host")) {
                error = context.getString(R.string.no_net);
            }
        } else {
            error = context.getString(R.string.error);
        }

        onFailed(error);
    }

    @Override
    public void onComplete() {

    }

    private String getErrorResponse(Response response) {
        ResponseBody responseBody = response.errorBody();
        String errorMsg = context.getString(R.string.error);
        if (responseBody != null) {
            try {
                String error = responseBody.string();
                if (isJsonValid(error)) {
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
}