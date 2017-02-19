package com.anhvu.podcastapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anhvu.podcastapp.R;
import com.anhvu.podcastapp.activity.PlayerActivity;
import com.anhvu.podcastapp.model.Episode;

import java.util.List;

/**
 * Created by leanh on 2/19/17.
 */

public class PodcastListAdapter extends RecyclerView.Adapter<PodcastListAdapter.PodcastViewHolder> {

    private Context context;
    private List<Episode> podcastList;

    public PodcastListAdapter(Context context, List<Episode> podcastList) {
        this.context = context;
        this.podcastList = podcastList;
    }

    @Override
    public PodcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.podcast_item_view, parent, false);

        return new PodcastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PodcastViewHolder holder, int position) {
        final Episode podcast = podcastList.get(position);

        holder.title.setText(podcast.getTitle());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayerActivity.class);
                intent.putExtra("podcast", podcast);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }

    public class PodcastViewHolder extends RecyclerView.ViewHolder {

        private CardView container;
        private TextView title;

        public PodcastViewHolder(View itemView) {
            super(itemView);
            container = (CardView) itemView.findViewById(R.id.podcast_item_container);
            title = (TextView) itemView.findViewById(R.id.podcast_item_title_txt);
        }
    }
}
