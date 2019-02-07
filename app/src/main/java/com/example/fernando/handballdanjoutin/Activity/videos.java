package com.example.fernando.handballdanjoutin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionVideo;
import com.example.fernando.handballdanjoutin.classes.ClsElements;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public class videos extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    ClsElements objetElement = new ClsElements();
    ClsAccionVideo objetAction = new ClsAccionVideo();
    String url ="yZMrLEPMBLQ";
    String claveYoutube = "AIzaSyBTPxawNOhM5__zxfDV647eLLQ-HNdhPME";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        objetAction.objetVideo = this;
        objetElement.youTubePlayerView = findViewById(R.id.idvideo);
        objetElement.youTubePlayerView.initialize(claveYoutube, this);
        this.setTitle("Videos");
        Bundle data  = getIntent().getExtras();
        if (data!=null){
             url = data.getString("url");
             objetAction.GetVideos();
        }else {
            objetAction.GetVideos();
        }



    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(url);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, 1).show();
        } else {
            String error = "error" + youTubeInitializationResult.toString();
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultcode, Intent data) {
        if (resultcode == 1) {
            getYoutubePlayerProvider().initialize(claveYoutube, this);
        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider() {
        return objetElement.youTubePlayerView;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }


}
