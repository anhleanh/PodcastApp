package com.anhvu.podcastapp.service.response;

import com.anhvu.podcastapp.model.Channel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leanh on 2/19/17.
 */

public class ChannelResponse {

    @SerializedName("head")
    @Expose
    private List<Head> head = null;
    @SerializedName("channel")
    @Expose
    private Channel channel;

    public List<Head> getHead() {
        return head;
    }

    public void setHead(List<Head> head) {
        this.head = head;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}


class Head {

    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
