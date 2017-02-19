package com.anhvu.podcastapp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.podcastapp.R;
import com.anhvu.podcastapp.model.Episode;

import java.io.IOException;

public class PlayerActivity extends AppCompatActivity implements MediaController.MediaPlayerControl, MediaPlayer.OnPreparedListener {

    private MediaPlayer mPlayer;
    private MediaController mMediaController;
    private Episode mEpisode;

    private TextView mTxtTitle, mTxtDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mTxtTitle = (TextView) findViewById(R.id.podcast_title_txt);
        mTxtDes = (TextView) findViewById(R.id.podcast_des_txt);
        Intent intent = getIntent();
        mEpisode = (Episode) intent.getSerializableExtra("podcast");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayer = new MediaPlayer();
        mMediaController = new MediaController(this);
        LoadPodcastTask task = new LoadPodcastTask();
        task.execute(mEpisode);
    }

    private void playPodcast(String url) {
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mPlayer.setDataSource(url);
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (SecurityException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mPlayer.prepare();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }

        mPlayer.setOnPreparedListener(this);
        mPlayer.start();
    }

    @Override
    public void start() {
        mPlayer.start();
    }

    @Override
    public void pause() {
        mPlayer.pause();
    }

    @Override
    public int getDuration() {
        return mPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mPlayer.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return mPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMediaController.hide();
        mPlayer.stop();
        mPlayer.release();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mMediaController.show();
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mMediaController.setMediaPlayer(this);
        mMediaController.setAnchorView(findViewById(R.id.podcast_player_holder));
        mMediaController.setEnabled(true);
        mMediaController.show();
    }

    class LoadPodcastTask extends AsyncTask<Episode, Void, Void> {

        ProgressDialog progressDialog;
        Episode episode;

        @Override
        protected Void doInBackground(Episode... params) {
            playPodcast(params[0].getMediaLink());
            episode = params[0];
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(PlayerActivity.this);
            progressDialog.setTitle("Please Wait");
            progressDialog.setMessage("Buffering...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mTxtTitle.setText(episode.getTitle());
            mTxtDes.setText(episode.getDescription());
            progressDialog.dismiss();
        }
    }
}

