package com.example.fernando.handballdanjoutin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionClub;

public class club extends AppCompatActivity {


    ClsAccionClub objetAction = new ClsAccionClub();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        objetAction.objetclub = this;
        this.setTitle("Club");
        objetAction.GetClub("club");
    }
}
