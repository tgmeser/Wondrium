package com.babyapps.wondrium.ui.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.babyapps.wondrium.databinding.FragmentExoPlayerBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;

public class ExoPlayerFragment extends Fragment {
    private FragmentExoPlayerBinding binding;
    private ExoPlayer exoPlayer = null;
    private Long playbackPosition = 0L;

    private boolean playWhenReady = true;

    public ExoPlayerFragment() {
        // Required empty public constructor
    }


    public static ExoPlayerFragment newInstance(String param1, String param2) {
        ExoPlayerFragment fragment = new ExoPlayerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareExoplayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentExoPlayerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void prepareExoplayer() {
        exoPlayer = new SimpleExoPlayer.Builder(requireContext()).build();
        exoPlayer.setPlayWhenReady(true);
        binding.playerView.setPlayer(exoPlayer);

        HttpDataSource.Factory dataSourceFactory = new DefaultHttpDataSource.Factory();
        MediaItem mediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/\n" +
                "BigBuckBunny.mp4");
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        releasePlayer();
    }

    @Override
    public void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    public void onPause() {
        super.onPause();
        releasePlayer();
    }
}