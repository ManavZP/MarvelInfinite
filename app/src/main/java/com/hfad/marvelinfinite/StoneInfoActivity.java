package com.hfad.marvelinfinite;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StoneInfoActivity extends AppCompatActivity {
    
    private TextView info;
    private ImageView stonePic;
    private TextView origin;
    private String typeStone;
    private TextView name;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stone_info);

        typeStone = getIntent().getStringExtra(StonesActivity.STONE_EXTRA);
        
        wireWidgets();
        setEverything();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    private void setEverything() {
        if(typeStone.equals("soul")){
            info.setText(R.string.soul_bio);
            origin.setText("Origin: Voromir");
            name.setText("Soul Stone");
            stonePic.setImageResource(R.drawable.soul);
        }
        if(typeStone.equals("mind")){
            info.setText(R.string.mind_bio);
            origin.setText("Origin: God Scepter");
            name.setText("Mind Stone");
            stonePic.setImageResource(R.drawable.mind);
        }
        if(typeStone.equals("time")){
            info.setText(R.string.time_bio);
            origin.setText("Origin: Eye of Agamotto");
            name.setText("Time Stone");
            stonePic.setImageResource(R.drawable.time);
        }
        if(typeStone.equals("space")){
            info.setText(R.string.space_bio);
            origin.setText("Origin: Tesseract");
            name.setText("Space Stone");
            stonePic.setImageResource(R.drawable.universes);
        }
        if(typeStone.equals("power")){
            info.setText(R.string.power_bio);
            origin.setText("Origin: The Orb");
            name.setText("Power Stone");
            stonePic.setImageResource(R.drawable.power);
        }
        if(typeStone.equals("reality")){
            info.setText(R.string.reality_bio);
            origin.setText("Origin: Aether");
            name.setText("Reality Stone");
            stonePic.setImageResource(R.drawable.reality);
        }
    }

    private void wireWidgets() {
        
        info = findViewById(R.id.textView_stoneinfo_bio);
        origin = findViewById(R.id.textView_stoneinfo_origin);
        stonePic = findViewById(R.id.imageView_stoneinfo_image);
        name = findViewById(R.id.textView_stoneinfo_name);
//        back = findViewById(R.id.imageView_stoneinfo_back);
        
    }
}
