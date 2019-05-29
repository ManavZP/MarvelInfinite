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


    //  Assigns index of related characters (3)

    int[] am = {3, 7, 10}; int[] bp = {3, 20, 2}; int[] bw = {11, 12, 3};
    int[] ca = {12, 20, 2}; int[] cm = {12, 3, 18}; int[] ds = {12, 19, 11};
    int[] dx = {18, 15, 9}; int[] fc = {3, 20, 0}; int[] gm = {18, 6, 15};
    int[] gr = {15, 18, 19}; int[] hk = {2, 3, 11}; int[] hl = {2, 19, 13};
    int[] im = {17, 3, 5}; int[] lk = {19, 11, 12}; int[] qs = {16, 10, 3};
    int[] rr = {9, 19, 18}; int[] sw = {14, 2, 10}; int[] sm = {12, 3, 5};
    int[] sl = {8, 15, 19}; int[] th = {13, 15, 3}; int[] ws = {3, 7, 1};

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
                Intent intent = new Intent(UniverseActivity.this, Heroes.class);
                intent.putExtra("Hero List", getHeroesList());
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

    public Character[] getHeroesList() {


        return new Character[] {
                new Character("Ant-Man", R.drawable.am, R.raw.antman, "Quantum Realm", "Scott Edward Harris Lang is a former criminal who was convinced by Pym Technologies CEO Hank Pym to take up his mantle as the new Ant-Man. \nAs Ant-Man, Lang fought against Darren Cross, Pym's protégé who became obsessed with Pym Particles and intended to recreate and sell the technology to terrorist organizations such as HYDRA and the Ten Rings. After his daughter, Cassie Lang, was taken hostage by Cross, Lang was able to send both of them into the Quantum Realm, where he saw Pym's wife Janet van Dyne, before successfully returning. Cross was presumably killed. Lang then began a romantic relationship with Pym's daughter, Hope van Dyne. \nDuring the conflict between Captain America and Iron Man, he was recruited by Falcon to fight on the Cap’s side."
                , am), //0
                new Character("Black Panther", R.drawable.bp, R.raw.blackpanther, "Dusted", "Tchaka, son of Tchalla, came into power as the King of Wakanda after his father’s death in America. \\nWith this role of king, he also took on the role of the Black Panther, a hero who defended Wakanda, a hidden city run by the power of Vibranium. Upon his return to Wakanda, he was met with resistance. A man named Erik Killmonger claimed to be the rightful heir to the throne. After winning the deciding ceremony, Erik decided it was time for Wakanda to show themselves to the world and help oppressed Africans all around the world-with the use of weapons. Along with the help of his sister Yuri, his ally M’baka, and a CIA agent named Everett Ross, Tchaka put an end to Killmonger’s plan and took back the throne. \\nHe then decided Wakanda should indeed show themselves to the world, but in a charitable way instead, sharing their power to help the world.", bp),//1
                new Character("Black Widow", R.drawable.bw, R.raw.bw, "status", "hi", bw), //2
                new Character("Captain America", R.drawable.ca, R.raw.captainamerica, "status", "hi", ca), //3
                new Character("Captain Marvel", R.drawable.cm, R.raw.cm, "status", "hi", cm), //4
                new Character("Doctor Strange", R.drawable.ds, R.raw.doctorstrange, "status", "hi", cm), //5
                new Character("Drax", R.drawable.dx, R.raw.dx, "status", "hi", dx), //6
                new Character("Falcon", R.drawable.fc, R.raw.falcon, "status", "hi", fc), //7
                new Character("Gamora", R.drawable.gm, R.raw.gm, "status", "hi", gm), //8
                new Character("Groot", R.drawable.gr, R.raw.groot, "status", "hi", gr), //9
                new Character("Hawkeye", R.drawable.hwk, R.raw.hawkeye, "status", "hi", hk), //10
                new Character("Hulk", R.drawable.hk, R.raw.hulk, "status", "hi", hl), //11
                new Character("Iron Man", R.drawable.im, R.raw.ironman, "status", "hi", im), //12
                new Character("Loki", R.drawable.lk, R.raw.loki, "status", "hi", lk), //13
                new Character("Quicksilver", R.drawable.qs, R.raw.quicksilver, "status", "hi", qs), //14
                new Character("Rocket Raccoon", R.drawable.rr, R.raw.rocketracoon, "status", "hi", rr), //15
                new Character("Scarlet Witch", R.drawable.sw, R.raw.scarletwitch, "status", "hi", sw), //16
                new Character("Spider-Man", R.drawable.sp, R.raw.spiderman, "Dusted", "Peter Benjamin Parker is a high school student who gained spider-like abilities, fighting crime across New York City as the alter ego of Spider-Man, hoping someday he'll live up to his heroes in the Avengers. \\nWhile Parker juggled all his continued superhero duties with the demands of his high-school life, he was approached by Tony Stark who recruited Spider-Man to join the Avengers Civil War, putting Spiderman into the brief conflict with his personal hero, Captain America. \\nParker then agreed and was given his new suit as well as brand new Stark technology in exchange for all his help, although Stark still did not make him an official member of the Avengers and instead returned Parker back home to continue his own hero work.", sm), //17
                new Character("Star-Lord", R.drawable.sl, R.raw.starlord, "status", "hi", sl), //18
                new Character("Thor", R.drawable.th, R.raw.thor, "status", "hi", th), //19
                new Character("Winter Soldier", R.drawable.ws, R.raw.wintersoldier, "status", "hi", ws) //20

        };
    }


    private void wireWidgets() {
        fox = findViewById(R.id.imageView_universe_fox);
        mcu = findViewById(R.id.imageView_universe_mcu);
        comic = findViewById(R.id.imageView_universe_comic);
        ig = findViewById(R.id.imageView_universe_back);
    }
}
