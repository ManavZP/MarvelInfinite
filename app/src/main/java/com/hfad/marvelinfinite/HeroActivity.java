package com.hfad.marvelinfinite;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class HeroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.quotes);
        String jsonString = readTextFile(XmlFileInputStream);
        Gson gson = new Gson();


        Intent intent = getIntent();
        int position = intent.getIntExtra("Hero Index", 0);
        Parcelable[] pa = intent.getParcelableArrayExtra("Hero List");
        final Character[] heroes = new Character[pa.length];
        System.arraycopy(pa,0,heroes,0,pa.length);

        final Character hero = heroes[position];

        ImageView hero1 = findViewById(R.id.hero1); ImageView hero2 = findViewById(R.id.hero2); ImageView hero3 = findViewById(R.id.hero3);

        TextView name = findViewById(R.id.name); TextView status = findViewById(R.id.status); TextView bio = findViewById(R.id.bio);

        name.setText(hero.getName()); status.setText(hero.getStatus()); bio.setText(hero.getBio());





        // Character-specific trailer

        final VideoView videoView = findViewById(R.id.moving);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + hero.getVideo());
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });



        //bios








        //  Suggested Characters

        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.rgb(119, 16, 16)).borderWidthDp(3.5f).cornerRadiusDp(80)
                .oval(false).build();





        Picasso.get().load(heroes[hero.getSuggested()[0]].getImageResource())
                .transform(transformation).into(hero1);

        Picasso.get().load(heroes[hero.getSuggested()[1]].getImageResource())
                .transform(transformation).into(hero2);

        Picasso.get().load(heroes[hero.getSuggested()[2]].getImageResource())
                .transform(transformation).into(hero3);

        hero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Resends and restarts this Activity with this Hero index and list.

                Intent intent = new Intent(HeroActivity.this, HeroActivity.class);
                intent.putExtra("Hero List", heroes);
                intent.putExtra("Hero Index", hero.getSuggested()[0]);

                finish();
                startActivity(intent);

            }
        });


        // Navigation Buttons

        hero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HeroActivity.this, HeroActivity.class);
                intent.putExtra("Hero List", heroes);
                intent.putExtra("Hero Index", hero.getSuggested()[1]);

                finish();
                startActivity(intent);

            }
        });



        hero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HeroActivity.this, HeroActivity.class);
                intent.putExtra("Hero List", heroes);
                intent.putExtra("Hero Index", hero.getSuggested()[2]);

                finish();
                startActivity(intent);

            }
        });
    }


    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
