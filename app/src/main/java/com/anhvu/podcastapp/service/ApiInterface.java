package com.anhvu.podcastapp.service;

import com.anhvu.podcastapp.service.response.ChannelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by leanh on 2/19/17.
 */

public interface ApiInterface {

    @GET("channel/{channelId}")
    Call<ChannelResponse> getChannel(@Path("channelId") String channelId);
}
