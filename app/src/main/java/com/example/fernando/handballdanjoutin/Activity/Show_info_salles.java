package com.example.fernando.handballdanjoutin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsElements;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.maps.Style;
import com.squareup.picasso.Picasso;

public class Show_info_salles extends AppCompatActivity {
    ClsElements e = new ClsElements();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, e.KEY_MAP);
        setContentView(R.layout.activity_sow_info_salles);
        e.img = findViewById(R.id.imgsalle);
        e.txt = findViewById(R.id.txtnom);
        e.txtAdress = findViewById(R.id.txtadresse);
        this.setTitle("Salles");
        Bundle data = getIntent().getExtras();
        if (data!=null){

            double lat = Double.valueOf(data.getString("latitud"));
            double lon = Double.valueOf(data.getString("longitud"));
            String img = data.getString("img");
            e.txt.setText(data.getString("nom"));
            e.txtAdress.setText(data.getString("adresse"));

            Picasso.with(this).load(img).resize(1200,800).into(e.img);
            com.mapbox.mapboxsdk.geometry.LatLng office = new com.mapbox.mapboxsdk.geometry.LatLng(lat, lon);
            e.map = findViewById(R.id.mapView);
            e.map.onCreate(savedInstanceState);
            e.map.getMapAsync(mapboxMap ->
                    mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {
                        mapboxMap.addMarker(new MarkerOptions().position(office).title(data.getString("nom")));
                        mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(office, 13));

                    })
            );
            e.map.setVisibility(View.VISIBLE);


        }
    }

    @Override
    public void onStart() {
        super.onStart();
        e.map.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        e.map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        e.map.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        e.map.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        e.map.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        e.map.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        e.map.onSaveInstanceState(outState);
    }


}
