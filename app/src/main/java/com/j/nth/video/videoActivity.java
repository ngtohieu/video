package com.j.nth.video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoActivity extends AppCompatActivity {
    VideoView videoView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        connect();
        Intent intent =getIntent();
        String path = intent.getStringExtra("path");
        videoView2.setVideoPath(path);
        videoView2.start();

        MediaController mediaController = new MediaController(videoActivity.this);
        mediaController.setMediaPlayer(videoView2);
        videoView2.setMediaController(mediaController);
    }
    void connect()
    {
        videoView2 = findViewById(R.id.videoView2);
    }
}
