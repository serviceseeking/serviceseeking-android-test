package com.serviceseeking.leadsapp.remote.responses;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    private String self;

    @SerializedName("related")
    private String related;

    @SerializedName("coverImage")
    private String coverImage;

    @SerializedName("logoImage")
    private String logoImage;

    @SerializedName("profileImage")
    private String profileImage;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
