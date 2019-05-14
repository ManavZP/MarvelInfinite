package com.hfad.marvelinfinite;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

public class StanLeeActivity extends AppCompatActivity {

    private TextView stanBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stan_lee);

        wireWidgets();


        final VideoView videoView = findViewById(R.id.moving);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.stan);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

        stanBio.setText(R.string.stanbio);
    }

    private void wireWidgets() {

        stanBio = findViewById(R.id.textView_stan_bio);

    }

}