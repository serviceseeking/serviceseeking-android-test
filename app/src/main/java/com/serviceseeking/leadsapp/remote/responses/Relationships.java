package com.serviceseeking.leadsapp.remote.responses;


import com.google.gson.annotations.SerializedName;

public class Relationships {

    @SerializedName("profile")
    private Profile profile;

    @SerializedName("suburb")
    private Suburb suburb;

    @SerializedName("attachments")
    private Attachments attachments;

    @SerializedName("job_filter")
    private JobFilter jobFilter;

    @SerializedName("eoi_templates")
    private Attachments eoiTemplates;

    @SerializedName("eoi_attachments")
    private Attachments eoiAttachements;

    public Suburb getSuburb() {
        return suburb;
    }

    public void setSuburb(Suburb suburb) {
        this.suburb = suburb;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public JobFilter getJobFilter() {
        return jobFilter;
    }

    public void setJobFilter(JobFilter jobFilter) {
        this.jobFilter = jobFilter;
    }

    public Attachments getEoiTemplates() {
        return eoiTemplates;
    }

    public void setEoiTemplates(Attachments eoiTemplates) {
        this.eoiTemplates = eoiTemplates;
    }

    public Attachments getEoiAttachements() {
        return eoiAttachements;
    }

    public void setEoiAttachements(Attachments eoiAttachements) {
        this.eoiAttachements = eoiAttachements;
    }
}
