package com.anhvu.podcastapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leanh on 2/19/17.
 */

public class Channel {

    @SerializedName("channel_id")
    @Expose
    private String channelId;
    @SerializedName("channel_title")
    @Expose
    private String channelTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private Object subtitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pod_link")
    @Expose
    private String podLink;
    @SerializedName("feed_link")
    @Expose
    private String feedLink;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("channel_type")
    @Expose
    private String channelType;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("votes")
    @Expose
    private String votes;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("subscribers")
    @Expose
    private String subscribers;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("episodes")
    @Expose
    private List<Episode> episodes = null;
    @SerializedName("show_count")
    @Expose
    private Integer showCount;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Object subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPodLink() {
        return podLink;
    }

    public void setPodLink(String podLink) {
        this.podLink = podLink;
    }

    public String getFeedLink() {
        return feedLink;
    }

    public void setFeedLink(String feedLink) {
        this.feedLink = feedLink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
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

    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public void setShowCount(Integer showCount) {
        this.showCount = showCount;
    }
}
