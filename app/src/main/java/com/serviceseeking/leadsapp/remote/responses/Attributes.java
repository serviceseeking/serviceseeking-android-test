package com.serviceseeking.leadsapp.remote.responses;


import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("name")
    private String name;

    @SerializedName("number")
    private String number;

    @SerializedName("phone")
    private String phone;

    @SerializedName("faxNumber")
    private String faxNumber;

    @SerializedName("address")
    private String address;

    @SerializedName("mobilePhone")
    private String mobilePhone;

    @SerializedName("websiteUrl")
    private String websiteUrl;

    @SerializedName("hidden")
    private boolean isHidden;

    @SerializedName("logoBgColorHex")
    private String logoBgColorHex;

    @SerializedName("reviewsCount")
    private int reviewsCount;

    @SerializedName("proMember")
    private boolean isProMember;

    @SerializedName("proPlus")
    private boolean isProPlus;

    @SerializedName("reviewsScore")
    private int reviewsScore;

    @SerializedName("reviewsScoreOutOfFive")
    private int reviewsScoreOutOfFive;

    @SerializedName("logoInitials")
    private String logoInitials;

    @SerializedName("description")
    private String description;

    @SerializedName("userName")
    private String userName;

    @SerializedName("email")
    private String email;

    @SerializedName("status")
    private String status;

    @SerializedName("suburbName")
    private String suburbName;

    @SerializedName("biddingClosesOn")
    private String biddingClosesOn;

    @SerializedName("distanceAway")
    private String distanceAway;

    @SerializedName("timing")
    private String timing;

    @SerializedName("canQuote")
    private boolean canQuote;

    @SerializedName("withinRange")
    private boolean isWithinRange;

    @SerializedName("new")
    private boolean isNew;

    @SerializedName("featured")
    private boolean isFeatured;

    @SerializedName("urgent")
    private boolean isUrgent;

    @SerializedName("private")
    private boolean isPrivate;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("updatedAt")
    private String updatedAt;

    @SerializedName("state")
    private String state;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    @SerializedName("postcode")
    private String postcode;

    @SerializedName("area")
    private String area;

    @SerializedName("region")
    private String region;

    @SerializedName("active")
    private boolean isActive;

    @SerializedName("abn")
    private String abn;

    @SerializedName("abnStatus")
    private String abnStatus;

    @SerializedName("membershipPlan")
    private String membershipPlan;

    @SerializedName("membershipActive")
    private boolean isMembershipActive;

    @SerializedName("identityVerified")
    private boolean isIdentityVerified;

    @SerializedName("creditCardValid")
    private boolean isCreditCardValid;

    @SerializedName("quoteLastSentAt")
    private String quoteLastSentAt;

    @SerializedName("quoteCountLast30Days")
    private int quoteCountLast30Days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public String getBiddingClosesOn() {
        return biddingClosesOn;
    }

    public void setBiddingClosesOn(String biddingClosesOn) {
        this.biddingClosesOn = biddingClosesOn;
    }

    public String getDistanceAway() {
        return distanceAway;
    }

    public void setDistanceAway(String distanceAway) {
        this.distanceAway = distanceAway;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public boolean isCanQuote() {
        return canQuote;
    }

    public void setCanQuote(boolean canQuote) {
        this.canQuote = canQuote;
    }

    public boolean isWithinRange() {
        return isWithinRange;
    }

    public void setWithinRange(boolean withinRange) {
        isWithinRange = withinRange;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getAbnStatus() {
        return abnStatus;
    }

    public void setAbnStatus(String abnStatus) {
        this.abnStatus = abnStatus;
    }

    public String getMembershipPlan() {
        return membershipPlan;
    }

    public void setMembershipPlan(String membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    public boolean isMembershipActive() {
        return isMembershipActive;
    }

    public void setMembershipActive(boolean membershipActive) {
        isMembershipActive = membershipActive;
    }

    public boolean isIdentityVerified() {
        return isIdentityVerified;
    }

    public void setIdentityVerified(boolean identityVerified) {
        isIdentityVerified = identityVerified;
    }

    public boolean isCreditCardValid() {
        return isCreditCardValid;
    }

    public void setCreditCardValid(boolean creditCardValid) {
        isCreditCardValid = creditCardValid;
    }

    public String getQuoteLastSentAt() {
        return quoteLastSentAt;
    }

    public void setQuoteLastSentAt(String quoteLastSentAt) {
        this.quoteLastSentAt = quoteLastSentAt;
    }

    public int getQuoteCountLast30Days() {
        return quoteCountLast30Days;
    }

    public void setQuoteCountLast30Days(int quoteCountLast30Days) {
        this.quoteCountLast30Days = quoteCountLast30Days;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public String getLogoBgColorHex() {
        return logoBgColorHex;
    }

    public void setLogoBgColorHex(String logoBgColorHex) {
        this.logoBgColorHex = logoBgColorHex;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public boolean isProMember() {
        return isProMember;
    }

    public void setProMember(boolean proMember) {
        isProMember = proMember;
    }

    public boolean isProPlus() {
        return isProPlus;
    }

    public void setProPlus(boolean proPlus) {
        isProPlus = proPlus;
    }

    public int getReviewsScore() {
        return reviewsScore;
    }

    public void setReviewsScore(int reviewsScore) {
        this.reviewsScore = reviewsScore;
    }

    public int getReviewsScoreOutOfFive() {
        return reviewsScoreOutOfFive;
    }

    public void setReviewsScoreOutOfFive(int reviewsScoreOutOfFive) {
        this.reviewsScoreOutOfFive = reviewsScoreOutOfFive;
    }

    public String getLogoInitials() {
        return logoInitials;
    }

    public void setLogoInitials(String logoInitials) {
        this.logoInitials = logoInitials;
    }
}
