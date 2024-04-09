package com.babyapps.wondrium.ui.player;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.babyapps.wondrium.databinding.ActivityExoPlayerBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;

public class ExoPlayerActivity extends AppCompatActivity {
    private ActivityExoPlayerBinding binding;
    private ExoPlayer exoPlayer;
    private long playbackPosition = 0L;
    private boolean playWhenReady = true;
    String videoUrl1;
    String videoUrl2;
    String videoUrl3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        videoUrl1 = getIntent().getStringExtra("VIDEO_URL_TO_PLAY_1");
        videoUrl2 = getIntent().getStringExtra("VIDEO_URL_TO_PLAY_2");
        videoUrl3 = getIntent().getStringExtra("VIDEO_URL_TO_PLAY_3");

        prepareExoplayer();
    }

    private void prepareExoplayer() {
        exoPlayer = new SimpleExoPlayer.Builder(this).build();
        exoPlayer.setPlayWhenReady(true);
        binding.playerView.setPlayer(exoPlayer);

        HttpDataSource.Factory dataSourceFactory = new DefaultHttpDataSource.Factory();
        Uri videoUri = Uri.parse(videoUrl3);
        MediaItem mediaItem = MediaItem.fromUri(videoUri);
        ProgressiveMediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(mediaItem);

        exoPlayer.setMediaSource(mediaSource);
        exoPlayer.seekTo(playbackPosition);
        exoPlayer.setPlayWhenReady(playWhenReady);
        exoPlayer.prepare();
    }

    private void releasePlayer() {
        if (exoPlayer != null) {
            playbackPosition = exoPlayer.getCurrentPosition();
            playWhenReady = exoPlayer.getPlayWhenReady();
            exoPlayer.release();
            exoPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        releasePlayer();
    }
}