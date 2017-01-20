package com.example.dusan.food.Fragments;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

/**
 * Created by wubon on 1/11/2017.
 */
public class RestaurantInfoFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private static final LatLng Index = new LatLng(45.251685, 19.840804);
    private Marker mIndex;
    private GoogleMap mMap;
    Button email, site, share;
    ImageButton call;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String location = getActivity().getIntent().getStringExtra("address");
        String naziv = getActivity().getIntent().getStringExtra("name");
        Geocoder geocoder = new Geocoder(getActivity().getBaseContext());
        try {
            List<Address> list = geocoder.getFromLocationName(location, 1);
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


        //mIndex = mMap.addMarker(new MarkerOptions().position(Index).title("Index house"));



       // googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Index, 13));


       // mMap.setOnMarkerClickListener(this);
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
        TextView address = (TextView) theView.findViewById(R.id.adresaRestorana);
        address.setText(getActivity().getIntent().getStringExtra("address"));
        TextView startHoure = (TextView) theView.findViewById(R.id.startHour);
        startHoure.setText(getActivity().getIntent().getStringExtra("startHour"));
        TextView endHoure = (TextView) theView.findViewById(R.id.endHour);
        endHoure.setText(getActivity().getIntent().getStringExtra("endHour"));







        call = (ImageButton) theView.findViewById(R.id.callButton);
        email = (Button) theView.findViewById(R.id.emailButton);
        site = (Button) theView.findViewById(R.id.siteButton);
        share = (Button) theView.findViewById(R.id.shareButton);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.mapaRestoranInfo);
        mapFragment.getMapAsync(this);



        call.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String number = getActivity().getIntent().getStringExtra("phone");
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view){
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","email@email.com", null));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");
                    intent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                }
        });

        site.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Uri uri = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });


        return theView;



    }






}
