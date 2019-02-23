package com.example.fernando.handballdanjoutin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionSalles;
import com.example.fernando.handballdanjoutin.classes.ClsAccionShowInfo;
import com.example.fernando.handballdanjoutin.classes.ClsElements;

public class show_info extends AppCompatActivity {

    ClsAccionShowInfo objetAction = new ClsAccionShowInfo();
    ClsElements objetElements = new ClsElements();
    ClsAccionSalles objetAccionSalles = new ClsAccionSalles();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        objetAction.objetInfo = this;
        objetElements.bundle = getIntent().getExtras();
        objetAccionSalles.objetSalles = this;



        if (objetElements.bundle != null) {
            String id = objetElements.bundle.getString("id");
            if (id.equals("1") || id.equals("3")){

                objetAction.GetShowInfo("dirigeants", objetElements.bundle.getString("id"));
            }else if (id.equals("4")){

                objetAccionSalles.GetSalles(id);
            }else if (id.equals("2")){
                Intent intent = new Intent(this, pdf_liens.class);
                startActivity(intent);
                finish();


            }
        }


    }
}
