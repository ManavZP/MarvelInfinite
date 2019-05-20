package com.hfad.marvelinfinite;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Animation blink;

    private ImageView marvelLogo;
    private ImageView stone;
    private ImageView web;
    private ImageView stan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        wireWidgets();
        makeAnimations();
        startAnimation();
        setOnClickListeners();

    }



    private void setOnClickListeners() {
        stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, UniverseActivity.class);
                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WebActivity.class);
                startActivity(intent);
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
//                startActivity(browserIntent);
            }
        });
        marvelLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FavCharsActivity.class);
                startActivity(intent);
            }
        });
        stan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StanLeeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void startAnimation() {
        stone.startAnimation(blink);
    }


    private void makeAnimations() {
        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
    }

    private void wireWidgets() {
        marvelLogo = findViewById(R.id.imageView_home_logo);
        stone = findViewById(R.id.imageView_home_universes);
        web = findViewById(R.id.imageView_home_web);
        stan = findViewById(R.id.imageView_home_title);
    }
}
