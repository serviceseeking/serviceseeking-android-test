package com.serviceseeking.leadsapp.remote.responses;


import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("links")
    private Links links;

    @SerializedName("attributes")
    private Attributes attributes;

    @SerializedName("relationships")
    private Relationships relationships;

    @SerializedName("attachments")
    private Attachments attachments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }
}
