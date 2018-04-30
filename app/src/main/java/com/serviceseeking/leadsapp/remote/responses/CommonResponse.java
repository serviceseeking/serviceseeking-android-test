package com.serviceseeking.leadsapp.remote.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.annotations.Nullable;

public class CommonResponse {

    @SerializedName("data")
    private Data data;

    @SerializedName("links")
    private Links links;

    @SerializedName("meta")
    private Token meta;

    @SerializedName("included")
    private List<Data> included;

    @SerializedName("errors")
    @Nullable
    private List<ErrorResponse> errors;

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> error) {
        this.errors = errors;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Token getMeta() {
        return meta;
    }

    public void setMeta(Token meta) {
        this.meta = meta;
    }

    public List<Data> getIncluded() {
        return included;
    }

    public void setIncluded(List<Data> included) {
        this.included = included;
    }
}
