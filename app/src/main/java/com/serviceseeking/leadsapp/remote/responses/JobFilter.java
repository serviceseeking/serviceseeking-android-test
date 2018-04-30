package com.serviceseeking.leadsapp.remote.responses;

import com.google.gson.annotations.SerializedName;

public class JobFilter {

    @SerializedName("links")
    private Links links;

    @SerializedName("data")
    private Data data;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
