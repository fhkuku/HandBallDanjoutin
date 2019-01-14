package com.example.fernando.handballdanjoutin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionShowInfo;
import com.example.fernando.handballdanjoutin.classes.ClsElements;

public class show_info extends AppCompatActivity {

    ClsAccionShowInfo objetAction = new ClsAccionShowInfo();
    ClsElements objetElements = new ClsElements();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        objetAction.objetInfo = this;
        objetElements.bundle = getIntent().getExtras();


        if (objetElements.bundle != null) {
            objetAction.GetShowInfo("dirigeants", objetElements.bundle.getString("id"));
        }


    }
}
