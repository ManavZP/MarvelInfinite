package com.hfad.marvelinfinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView poster = findViewById(R.id.poster);
        TextView quote = findViewById(R.id.quote);


        //  Displays a 1 of 4 Characters Randomly

        int index = (int)(Math.random() *  (posters.length - 1));
        poster.setImageResource(posters[index]);
        quote.setText(quotes[index]);


        //  Delay

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(6500);
                } catch (InterruptedException e) {
                    // TODO: and ADD MUSIC
                    e.printStackTrace();
                } finally {

                    Intent home = new Intent(Splash.this, LoginActivity.class);
                    startActivity(home);
                    Splash.this.finish();
                }
            }
        };
        timer.start();
    }
    private int[] posters = {      R.drawable.capt, R.drawable.iron,
                                    R.drawable.spider, R.drawable.odin

    };

    private String[] quotes = {     "\"We will...Whatever it takes.\"",
                                    "\"I shouldn't be alive, unless it was for a reason.\"",
                                    "\"Somebody's got to look out for the little guy, right?\"",
                                     "\"I would rather be a good man than a great king.\""

    };
}

