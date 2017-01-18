package com.example.dusan.food.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dusan.food.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

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


        return view;
    }




    @Override


    public void onMapReady(GoogleMap googleMap){



        mMap = googleMap;


        mIndex = mMap.addMarker(new MarkerOptions().position(Index).title("Index house"));

        mToster = mMap.addMarker(new MarkerOptions().position(Toster).title("Toster"));

        mRoma = mMap.addMarker(new MarkerOptions().position(Roma).title("Roma"));

        mSavoca = mMap.addMarker(new MarkerOptions().position(Savoca).title("Savoca"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Index, 13));


        mMap.setOnMarkerClickListener(this);

    }


    @Override
    public boolean onMarkerClick(Marker marker) {


        return false;

    }
}