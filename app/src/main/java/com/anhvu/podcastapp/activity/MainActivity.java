package com.anhvu.podcastapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anhvu.podcastapp.R;
import com.anhvu.podcastapp.adapter.PodcastListAdapter;
import com.anhvu.podcastapp.service.ApiClient;
import com.anhvu.podcastapp.service.ApiInterface;
import com.anhvu.podcastapp.service.response.ChannelResponse;
import com.anhvu.podcastapp.model.Episode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRcvPodcast;
    private PodcastListAdapter mAdapter;
    private List<Episode> mPodcastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPodcastList = new ArrayList<>();

        mRcvPodcast = (RecyclerView) findViewById(R.id.podcast_list);
        mRcvPodcast.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<ChannelResponse> call = apiService.getChannel("16948");

        call.enqueue(new Callback<ChannelResponse>() {
            @Override
            public void onResponse(Call<ChannelResponse> call, Response<ChannelResponse> response) {
                mPodcastList = response.body().getChannel().getEpisodes();
                mAdapter = new PodcastListAdapter(getApplicationContext(), mPodcastList);
                mRcvPodcast.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ChannelResponse> call, Throwable t) {

            }
        });


    }
}
