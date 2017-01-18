package com.example.dusan.food.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dusan.food.R;
import com.example.dusan.food.activities.RestaurantActivity;
import com.example.dusan.food.database.DatabaseAdapter;
import com.example.dusan.food.database.MyDBHandler;
import com.example.dusan.food.model.Restaurant;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class RestaurantsFragment extends Fragment{
    ArrayList<Restaurant> restaurants;
    DatabaseAdapter db;
    MyDBHandler myDBHandler;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.restaurants_fragment_layout,null);



    }









    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        restaurants = new ArrayList<>();


        /*
        db = new DatabaseAdapter(getActivity().getBaseContext());
        db.insert("Index House", "Sandwiches, Pancakes, Grill, Serbian food...");
        db.insert("Pizzeria Savoca", "Italian food, Pizza, Mediterranean food...");
        db.insert("Toster", "Serbian food, Grill, Sadnwiches");
        db.insert("Giros Land", "Grill, Serbian food, Greek food...");
        db.insert("Roma", "Sandwiches, Italian food, Pizza, Grill..");
        */



        retrieveData();
        populateListView();
        registerClickBack();


    }



    private void retrieveData() {

        DatabaseAdapter db = new DatabaseAdapter(getActivity());
        db.openDB();

        Cursor c = db.read();



        while (c.moveToNext()){

            int id = c.getInt(0);
            String name = c.getString(1);
            String desc = c.getString(2);


            Restaurant r = new Restaurant(id, name, desc);



            restaurants.add(r);



            db.CloseDB();



        }

    }


    private void populateListView() {


        ArrayAdapter<Restaurant> adapter = new MyListAdapter();
        ListView list = (ListView) getView().findViewById(R.id.restaurantsListView);
        list.setAdapter(adapter);


    }




    private class MyListAdapter extends ArrayAdapter<Restaurant> {
        public MyListAdapter(){
            super(getActivity(), R.layout.row_layout, restaurants);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;
            if(itemView == null){
                itemView = getActivity().getLayoutInflater().inflate(R.layout.row_layout, parent, false);
            }

            Restaurant currentRestaurant = restaurants.get(position);


            TextView makeText = (TextView) itemView.findViewById(R.id.item_name);
            makeText.setText(currentRestaurant.getName());






            return itemView;
        }
    }


    private void registerClickBack() {

        ListView list = (ListView) getView().findViewById(R.id.restaurantsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Restaurant clickedRest = restaurants.get(position);
                Intent i = new Intent(getActivity().getApplicationContext(), RestaurantActivity.class);
                i.putExtra("name", clickedRest.getName());
                i.putExtra("descr", clickedRest.getDescription());
                startActivity(i);

            }
        });
    }



}