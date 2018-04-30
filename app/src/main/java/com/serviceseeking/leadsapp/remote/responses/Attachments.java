package com.serviceseeking.leadsapp.remote.responses;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attachments {

    @SerializedName("links")
    private Links links;

    @SerializedName("data")
    private List<Data> data;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
