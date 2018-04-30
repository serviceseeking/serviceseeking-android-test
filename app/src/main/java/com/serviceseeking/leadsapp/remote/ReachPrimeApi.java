package com.serviceseeking.leadsapp.remote;

import com.serviceseeking.leadsapp.remote.requests.LoginRequest;
import com.serviceseeking.leadsapp.remote.responses.CommonResponse;
import com.serviceseeking.leadsapp.remote.responses.GetLeadsResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReachPrimeApi {

    @GET("5ae2d1353100004f00083b9b")
    Observable<CommonResponse> loginTest();

    @GET("5ae2d4a23100004f00083bb1")
    Observable<GetLeadsResponse> getLeadsTest();

    @Headers({
            "accept: application/vnd.api+json; version=1",
            "content-type: application/vnd.api+json"
    })
    @GET("leads/{lead_id}")
    Observable<CommonResponse> getLeadResponse(@Header("authorization") String authorization,
                                               @Path("lead_id") String leadId);

    @Headers({
            "accept: application/vnd.api+json; version=1",
            "content-type: application/vnd.api+json",
    })
    @GET("leads")
    Observable<GetLeadsResponse> getLeadsResponse(@Header("authorization") String authorization);
//                                                  @Query("page") int pageSize,
//                                                  @Query("page") int pageNumber);

    @Headers({
            "accept: application/vnd.api+json; version=1",
            "content-type: application/vnd.api+json",
            "authorization: Basic c3NzdGFnaW5nOnNzVDNzdDFuZyE="
    })
    @POST("users/sign_in")
    Observable<CommonResponse> loginUser(@Body LoginRequest body);

}