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
    private static final LatLng Index = new LatLng(45.251685, 19.840804);
    private static final LatLng Toster = new LatLng(45.249943, 19.850586);
    private static final LatLng Roma = new LatLng(45.249933 , 19.847285);
    private static final LatLng Savoca = new LatLng(45.261256, 19.831923);

    private Marker mIndex;
    private Marker mToster;
    private Marker mRoma;
    private Marker mSavoca;

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


        

      //  mMap = googleMap;


       // mIndex = mMap.addMarker(new MarkerOptions().position(Index).title("Index house"));

       // mToster = mMap.addMarker(new MarkerOptions().position(Toster).title("Toster"));

       // mRoma = mMap.addMarker(new MarkerOptions().position(Roma).title("Roma"));

      //  mSavoca = mMap.addMarker(new MarkerOptions().position(Savoca).title("Savoca"));

       // googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Index, 13));


        mMap.setOnMarkerClickListener(this);

    }








    @Override
    public boolean onMarkerClick(Marker marker) {

      String naziv = marker.getTitle();



        int count = 0;
        while (restaurants.size() > count){
            String nazivv = restaurants.get(1).getName();
            if(naziv == nazivv){

                String desc = restaurants.get(2).getDescription();
                String img = restaurants.get(3).getDescription();
                String addressa = restaurants.get(4).getAddressa();
                Integer startHour = restaurants.get(5).getStartHour();
                Integer endHour = restaurants.get(6).getEndHour();
                String phone = restaurants.get(7).getPhone();
                String email = restaurants.get(8).getEmail();

                Intent intent = new Intent(getActivity().getBaseContext(), RestaurantActivity.class);
                intent.putExtra("name", nazivv);
                intent.putExtra("descr", desc);
                intent.putExtra("address", addressa);
                intent.putExtra("startHour", startHour);
                intent.putExtra("endHour", endHour);
                intent.putExtra("phone", phone);
                intent.putExtra("email", email);
                startActivity(intent);

            }
            count++;
        }

       return  false;
    }
}