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

    private ImageView ig;

    public static final String STONE_EXTRA = "stone";





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
                intent.putExtra(STONE_EXTRA, "soul");
                startActivity(intent);
            }
        });
        timeStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StonesActivity.this, StoneInfoActivity.class);
                intent.putExtra(STONE_EXTRA, "time");
                startActivity(intent);
            }
        });
        mindStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StonesActivity.this, StoneInfoActivity.class);
                intent.putExtra(STONE_EXTRA, "mind");
                startActivity(intent);
            }
        });
        spaceStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StonesActivity.this, StoneInfoActivity.class);
                intent.putExtra(STONE_EXTRA, "space");
                startActivity(intent);
            }
        });
        powerStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StonesActivity.this, StoneInfoActivity.class);
                intent.putExtra(STONE_EXTRA, "power");
                startActivity(intent);
            }
        });
        realityStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StonesActivity.this, StoneInfoActivity.class);
                intent.putExtra(STONE_EXTRA, "reality");
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
        soulStone = findViewById(R.id.imageView_stones_soul);
        timeStone = findViewById(R.id.imageView_stones_time);
        mindStone = findViewById(R.id.imageView_stones_mind);
        spaceStone = findViewById(R.id.imageView_stones_space);
        powerStone = findViewById(R.id.imageView_stones_power);
        realityStone = findViewById(R.id.imageView_stones_reality);

        ig = findViewById(R.id.imageView_stones_back);

    }
}
