package com.serviceseeking.leadsapp.remote.responses;


import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("links")
    private Links links;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
