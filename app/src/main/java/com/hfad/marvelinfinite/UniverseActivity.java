package com.hfad.marvelinfinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UniverseActivity extends AppCompatActivity {


    private ImageView mcu;
    private ImageView fox;
    private ImageView comic;
    private ImageView ig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);

        wireWidgets();
        setOnClickListeners();

    }

    private void setOnClickListeners() {
        mcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UniverseActivity.this, Characters.class);
                startActivity(intent);
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void wireWidgets() {
        fox = findViewById(R.id.imageView_universe_fox);
        mcu = findViewById(R.id.imageView_universe_mcu);
        comic = findViewById(R.id.imageView_universe_comic);
        ig = findViewById(R.id.imageView_universe_back);
    }
}
