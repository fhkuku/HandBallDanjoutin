package com.example.fernando.handballdanjoutin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionLiens;

public class liens extends AppCompatActivity {

    ClsAccionLiens objetAction = new ClsAccionLiens();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liens);
        this.setTitle("Federation liens");
        objetAction.objetlien = this;
        objetAction.GetLiens();



    }
}
