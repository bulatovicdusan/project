package com.example.dusan.food.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.renderscript.Element;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dusan.food.R;
import com.example.dusan.food.activities.RestaurantActivity;
import com.example.dusan.food.database.DatabaseAdapter;
import com.example.dusan.food.model.Restaurant;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    ArrayList<Restaurant> restaurants;


    private GoogleMap mMap;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.map_fragment_layout, null, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        restaurants = new ArrayList<>();


        return view;
    }




    @Override


    public void onMapReady(GoogleMap googleMap){

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
            Integer startMinute = c.getInt(6);
            String phone = c.getString(7);
            String email = c.getString(8);



            Restaurant r = new Restaurant(id, name, desc, img, address , startHour, startMinute, phone, email);



            restaurants.add(r);



            db.CloseDB();



        }



        int br = 0;
        int count = 0;
        while (restaurants.size() > count) {
            String naziv = restaurants.get(br).getName();
            String addresa = restaurants.get(br).getAddressa();

            mMap = googleMap;
            Geocoder geocoder = new Geocoder(getActivity().getBaseContext());
            try {
                List<Address> list = geocoder.getFromLocationName(addresa, 1);
                Address add = list.get(0);
                String locality = add.getLocality();
                double lat = add.getLatitude();
                double lng = add.getLongitude();
                LatLng x = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(x).title(naziv));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(x, 13));
                mMap.setOnMarkerClickListener(this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            br ++;
            count++;
        }





    }








    @Override
    public boolean onMarkerClick(Marker marker) {

      String naziv = marker.getTitle();



        int count = 0;
        while (restaurants.size() > count){
            String nazivv = restaurants.get(1).getName();
            if(naziv == nazivv){

                String desc = restaurants.get(2).getDescription();
                String img = restaurants.get(3).getImg();
                String addressa = restaurants.get(4).getAddressa();
                Integer startHour = restaurants.get(5).getStartHour();
                Integer endHour = restaurants.get(6).getEndHour();
                String phone = restaurants.get(7).getPhone();
                String email = restaurants.get(8).getEmail();

                Intent intent = new Intent(getActivity().getBaseContext(), RestaurantActivity.class);
                intent.putExtra("name", nazivv);
                intent.putExtra("descr", desc);
                intent.putExtra("img", img);
                intent.putExtra("address", addressa);
                intent.putExtra("startHour", startHour);
                intent.putExtra("endHour", endHour);
                intent.putExtra("phone", phone);
                intent.putExtra("email", email);
                startActivity(intent);

            }
            count++;
        }

       return false;
    }
}