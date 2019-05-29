package com.hfad.marvelinfinite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterAdapter extends BaseAdapter {

    private final Context mContext;
    public final Character[] heroes;

    public CharacterAdapter(Context context, Character[] heroes) {
        this.mContext = context;
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }



    public View getView(int position, View convertView, ViewGroup parent) {

        final Character hero = heroes[position];


        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_character, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = convertView.findViewById(R.id.textview_hero_name);

        imageView.setImageResource(hero.getImageResource());
        nameTextView.setText(hero.getName());

        return convertView;
    }
}
