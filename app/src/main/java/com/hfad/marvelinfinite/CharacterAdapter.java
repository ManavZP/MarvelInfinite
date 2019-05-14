package com.hfad.marvelinfinite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;




import java.util.List;

public class CharacterAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    private List<FavCharacter> favCharacterList;



    public CharacterAdapter(@NonNull Context context, int resource, @NonNull List<FavCharacter> favCharacterList) {
        super(context, resource, favCharacterList);

        this.context = context;
        this.resource = resource;
        this.favCharacterList = favCharacterList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_favcharlist, parent,false);
        }

        TextView textViewName = convertView.findViewById(R.id.textView_favcharitem_name);
        ImageView imageViewImg = convertView.findViewById(R.id.imageView_favcharitem_image);

        FavCharacter currentChar = favCharacterList.get(position);
        textViewName.setText(currentChar.getName());

        Picasso.get().load(currentChar.getImgUrl()).into(imageViewImg);

        return convertView;


    }

}
