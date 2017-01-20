package com.example.dusan.food.Fragments;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dusan.food.R;
import com.example.dusan.food.activities.MealActivity;
import com.example.dusan.food.activities.RestaurantActivity;
import com.example.dusan.food.database.DatabaseAdapter;
import com.example.dusan.food.database.MyDBHandler;
import com.example.dusan.food.model.Meal;
import com.example.dusan.food.model.Restaurant;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by wubon on 1/11/2017.
 */
public class MealInfoFragment extends Fragment {
    ArrayList<Meal> meals;
    MyDBHandler myDBHandler;
    public static final String TABLE_MEALS = "meals";
    public static final String COLUMN_ID_RESTORANA= "idRestorana";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.meals_layout,null);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        meals = new ArrayList<>();


        int res_id = getActivity().getIntent().getIntExtra("id",0);
      //  myDBHandler.getAllMealById(res_id);
        retrieveData();
        populateListView();
        registerClickBack();

    }


    private void retrieveData() {

        DatabaseAdapter db = new DatabaseAdapter(getActivity());
        db.openDB();

        Cursor c = db.read2();




        while (c.moveToNext()){

            int id = c.getInt(0);
            String name = c.getString(1);
            String desc = c.getString(2);
            Double price = c.getDouble(3);
            Integer idRest = c.getInt(4);
            Integer idTag = c.getInt(5);


            Meal m = new Meal(id, name, desc, price,idRest, idTag);



            meals.add(m);



            db.CloseDB();



        }

    }

    private void populateListView() {


        ArrayAdapter<Meal> adapter = new MyListAdapter();
        ListView list = (ListView) getView().findViewById(R.id.mealsListView);
        list.setAdapter(adapter);


    }



    private class MyListAdapter extends ArrayAdapter<Meal> {
        public MyListAdapter(){
            super(getActivity(), R.layout.row_meals_layout, meals);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;
            if(itemView == null){
                itemView = getActivity().getLayoutInflater().inflate(R.layout.row_meals_layout, parent, false);
            }


            Meal currentMeal = meals.get(position);


            TextView makeText = (TextView) itemView.findViewById(R.id.meal_name);
            makeText.setText(currentMeal.getName());
            TextView mText = (TextView) itemView.findViewById(R.id.descMeal);
            mText.setText(currentMeal.getDescription());






            return itemView;
        }
    }


    private void registerClickBack() {

        ListView list = (ListView) getView().findViewById(R.id.mealsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {





                Meal clickedMeal = meals.get(position);
                Double cenaDouble = clickedMeal.getPrice();
                String cena = cenaDouble.toString();
                Intent i = new Intent(getActivity().getApplicationContext(), MealActivity.class);
                i.putExtra("name", clickedMeal.getName());
                i.putExtra("descr", clickedMeal.getDescription());
                i.putExtra("price", cena);
                startActivity(i);

            }
        });
    }

}
