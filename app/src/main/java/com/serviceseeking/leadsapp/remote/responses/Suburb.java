package com.serviceseeking.leadsapp.remote.responses;


import com.google.gson.annotations.SerializedName;

public class Suburb {

    @SerializedName("links")
    private Links link;

    @SerializedName("data")
    private Data data;

    public Links getLink() {
        return link;
    }

    public void setLink(Links link) {
        this.link = link;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
