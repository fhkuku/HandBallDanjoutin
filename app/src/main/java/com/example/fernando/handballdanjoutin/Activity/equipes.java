package com.example.fernando.handballdanjoutin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionEquipes;
import com.example.fernando.handballdanjoutin.classes.ClsEquipes;

public class equipes extends AppCompatActivity {

    ClsAccionEquipes objetAction = new ClsAccionEquipes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes);

        objetAction.objetEquipes = this;
        objetAction.GetEquipes();
        this.setTitle("Equipes");



    }
}
