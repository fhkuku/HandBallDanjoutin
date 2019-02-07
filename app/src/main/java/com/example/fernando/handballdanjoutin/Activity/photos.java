package com.example.fernando.handballdanjoutin.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionPhotos;
import com.example.fernando.handballdanjoutin.classes.ClsElements;

public class photos extends AppCompatActivity {

    ClsAccionPhotos objetAccion = new ClsAccionPhotos();
    ClsElements objetElement = new ClsElements();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        objetAccion.objetPhotos = this;
        objetElement.collapsingToolbarLayout = findViewById(R.id.idcollapsing);
        objetElement.collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.StyleAppBar);
        objetElement.collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.StyleAppBar);
        objetAccion.GetPhotos();
        this.setTitle("Medias");
    }
}
