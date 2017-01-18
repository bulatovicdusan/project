package com.example.dusan.food.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dusan.food.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by wubon on 1/11/2017.
 */
public class RestaurantInfoFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private static final LatLng Index = new LatLng(45.251685, 19.840804);
    private Marker mIndex;
    private GoogleMap mMap;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mIndex = mMap.addMarker(new MarkerOptions().position(Index).title("Index house"));



        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Index, 13));


        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        View theView = inflater.inflate(R.layout.restaurant_info_layout,null);
        TextView tvName = (TextView) theView.findViewById(R.id.nazivRestorana);
        TextView tvDescr = (TextView) theView.findViewById(R.id.opisRestorana);

        tvName.setText(getActivity().getIntent().getStringExtra("name"));
        tvDescr.setText(getActivity().getIntent().getStringExtra("descr"));

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.mapaRestoranInfo);
        mapFragment.getMapAsync(this);




        return theView;











    }
}
