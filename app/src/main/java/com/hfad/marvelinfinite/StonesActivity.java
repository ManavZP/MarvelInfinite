package com.hfad.marvelinfinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StonesActivity extends AppCompatActivity {

    private ImageView soulStone;
    private ImageView timeStone;
    private ImageView mindStone;
    private ImageView spaceStone;
    private ImageView powerStone;
    private ImageView realityStone;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stones);

        wireWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        soulStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StonesActivity.this, StoneInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void wireWidgets() {
        soulStone = findViewById(R.id.imageView_stones_soul);
        timeStone = findViewById(R.id.imageView_stones_time);
        mindStone = findViewById(R.id.imageView_stones_mind);
        spaceStone = findViewById(R.id.imageView_stones_space);
        powerStone = findViewById(R.id.imageView_stones_power);
        realityStone = findViewById(R.id.imageView_stones_reality);

    }
}
