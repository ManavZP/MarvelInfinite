package com.hfad.marvelinfinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class FavCharsActivity extends AppCompatActivity {

    private ListView favcharlist;
    private ImageView gauntlet;

    private CharacterAdapter adapter;
    private List<FavCharacter> charslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_chars);

        wireWidgets();
        setOnClickListeners();
        populateListView();
        Log.d("ENQUEUE", "onFailure: " + this.getClass());

    }

    private void setOnClickListeners() {

        gauntlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void populateListView() {


        //refactor to only get the item that belongs to the user
        //get the current user's object Id (use Backendless.UserService)
        //make a dataquery and use the advanced object retrieval pattern
        //to find all restaurant's whose owner id matches the user's object id
        //sample Where clause with string: name = "joe
        String ownerID = Backendless.UserService.CurrentUser().getObjectId();
        String whereClause = "ownerId = '" + ownerID + "'";
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(whereClause);

        Backendless.Data.of( FavCharacter.class).find(queryBuilder, new AsyncCallback<List<FavCharacter>>(){
            @Override
            public void handleResponse(final List<FavCharacter> charslist )
            {
//                FavCharsActivity.this.charslist = charslist;
//                adapter = new CharacterAdapter(FavCharsActivity.this, android.R.layout.simple_list_item_1, charslist);
//                favcharlist.setAdapter(adapter);


//                listViewRestaurant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent restaurantThing = new Intent(RestaurantListActivity.this,
//                                RestaurantActivity.class);
//                        restaurantThing.putExtra(EXTRA_RESTAURANT, restaurantList.get(position));
//                        startActivity(restaurantThing);
//                    }
//                });

            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                // an error has occurred, the error code can be retrieved with fault.getCode()
                Toast.makeText(FavCharsActivity.this,
                        fault.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

    private void wireWidgets() {

        gauntlet = findViewById(R.id.imageView_listView_back);
        favcharlist = findViewById(R.id.listview_favcharlist);

    }
}
