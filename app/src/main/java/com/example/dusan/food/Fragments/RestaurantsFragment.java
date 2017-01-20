package com.example.dusan.food.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dusan.food.R;
import com.example.dusan.food.activities.MainActivity;
import com.example.dusan.food.activities.RestaurantActivity;
import com.example.dusan.food.database.DatabaseAdapter;
import com.example.dusan.food.database.MyDBHandler;
import com.example.dusan.food.model.Restaurant;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class RestaurantsFragment extends Fragment{
    ArrayList<Restaurant> restaurants;
    DatabaseAdapter db;
    MyDBHandler myDBHandler;
    private static final int REQUEST_READ_STORAGE = 112;


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
        boolean hasPermission = (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_STORAGE);
        }

        */





        retrieveData();
        populateListView();
        registerClickBack();





    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQUEST_READ_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //reload my activity with permission granted or use the features what required the permission


                } else
                {
                    Toast.makeText(getActivity(), "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show();
                }
            }
        }

    }



    private void retrieveData() {

        DatabaseAdapter db = new DatabaseAdapter(getActivity());
        db.openDB();

        Cursor c = db.read();



        while (c.moveToNext()){

            int id = c.getInt(0);
            String name = c.getString(1);
            String desc = c.getString(2);
            String img = c.getString(3);
            String address = c.getString(4);
            Integer startHour = c.getInt(5);
            Integer endHour = c.getInt(6);
            String phone = c.getString(7);
            String email = c.getString(8);



            Restaurant r = new Restaurant(id, name, desc, img, address , startHour,  endHour, phone, email);



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
            TextView desc = (TextView) itemView.findViewById(R.id.descRest);
            desc.setText(currentRestaurant.getDescription());

          //  String photo = currentRestaurant.getImg();
         //   ImageView img = (ImageView) itemView.findViewById(R.id.item_icon);
          //  String photoPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() +"/"+ photo;
          //  File imgFile = new File(photoPath);
          //  Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
         //   img.setImageBitmap(bitmap);








            return itemView;




        }
    }


    private void registerClickBack() {

        ListView list = (ListView) getView().findViewById(R.id.restaurantsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Restaurant clickedRest = restaurants.get(position);
                Integer startH = clickedRest.getStartHour();
                String startHour = startH.toString();


                Integer endH = clickedRest.getEndHour();
                String endHour = endH.toString();




                Intent i = new Intent(getActivity().getApplicationContext(), RestaurantActivity.class);
                i.putExtra("id", clickedRest.getId());
                i.putExtra("name", clickedRest.getName());
                i.putExtra("descr", clickedRest.getDescription());
                i.putExtra("address", clickedRest.getAddressa());
                i.putExtra("startHour", startHour);
                i.putExtra("endHour", endHour);
                i.putExtra("phone", clickedRest.getPhone());
                i.putExtra("email", clickedRest.getEmail());
                startActivity(i);

            }
        });
    }



}