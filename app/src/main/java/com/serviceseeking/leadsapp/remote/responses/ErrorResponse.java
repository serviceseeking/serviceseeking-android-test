package com.serviceseeking.leadsapp.remote.responses;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {

    @SerializedName("title")
    private String title;

    @SerializedName("detail")
    private String detail;

    @SerializedName("id")
    private String id;

    @SerializedName("links")
    private String links;

    @SerializedName("status")
    private String status;

    @SerializedName("code")
    private int code;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
