package com.example.fernando.handballdanjoutin.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsElements;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.maps.Style;

public class contact extends AppCompatActivity {

    ClsElements elements = new ClsElements();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, elements.KEY_MAP);
        setContentView(R.layout.activity_contact);
        this.setTitle("Contact");
        com.mapbox.mapboxsdk.geometry.LatLng office = new com.mapbox.mapboxsdk.geometry.LatLng(47.646891, 6.8741397);
        elements.map = findViewById(R.id.mapView);
        elements.map.onCreate(savedInstanceState);
        elements.map.getMapAsync(mapboxMap ->
                mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {
                    mapboxMap.addMarker(new MarkerOptions().position(office).title("HandBall de Danjoutin"));
                    mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(office, 13));

                })
        );

        elements.btn = findViewById(R.id.btnEmail);
        elements.btn.setOnClickListener(v -> {
            sendEmail();
        });
    }

    protected void sendEmail() {
        String[] TO = {"5290009@ffhandball.net"}; //aquí pon tu correo
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("À:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        try {
            startActivity(Intent.createChooser(emailIntent, "Envoyant email..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "Vous n'avez pas des clients d'email installé.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        elements.map.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        elements.map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        elements.map.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        elements.map.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        elements.map.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        elements.map.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        elements.map.onSaveInstanceState(outState);
    }







}
