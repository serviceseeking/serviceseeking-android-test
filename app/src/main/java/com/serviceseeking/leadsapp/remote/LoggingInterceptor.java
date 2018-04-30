package com.serviceseeking.leadsapp.remote;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

//        long t1 = System.nanoTime();
//        Log.d(">>>>>>>>>>>>", String.format("Sending request %s on %s%n%s",
//                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);
//        Log.d(">>>>>>", response.headers() + " <");
//        Log.d(">>>>>>>>>>>", String.format("Received response for %s in body body\n%s", response.headers(), response.body().string()));

        return response;
    }
}