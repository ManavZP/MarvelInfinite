package com.hfad.marvelinfinite;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Heroes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        Intent intent = getIntent();
        Parcelable[] pa = intent.getParcelableArrayExtra("Hero List");
        final Character[] heroes = new Character[pa.length];
        System.arraycopy(pa,0,heroes,0,pa.length);

        GridView gridView = findViewById(R.id.gridview);
        CharacterAdapter characterAdapter = new CharacterAdapter(this, heroes);
        gridView.setAdapter(characterAdapter);


        //TODO: Styling and QS profile



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                // Sends the Hero index and to next Activity to display correct hero.

                Intent intent = new Intent(Heroes.this, HeroActivity.class);
                intent.putExtra("Hero Index", position);
                intent.putExtra("Hero List", heroes);
                startActivity(intent);


            }
        });

    }

}
