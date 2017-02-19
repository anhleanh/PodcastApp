package com.anhvu.podcastapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by leanh on 2/19/17.
 */

public class Episode implements Serializable{
    @SerializedName("show_id")
    @Expose
    private String showId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("media_link")
    @Expose
    private String mediaLink;
    @SerializedName("pod_link")
    @Expose
    private String podLink;
    @SerializedName("author")
    @Expose
    private Object author;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("votes")
    @Expose
    private String votes;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("mime_type")
    @Expose
    private String mimeType;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("size")
    @Expose
    private String size;

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getPodLink() {
        return podLink;
    }

    public void setPodLink(String podLink) {
        this.podLink = podLink;
    }

    public Object getAuthor() {
        return author;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
