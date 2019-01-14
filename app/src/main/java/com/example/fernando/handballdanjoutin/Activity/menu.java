package com.example.fernando.handballdanjoutin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionMenu;
import com.example.fernando.handballdanjoutin.classes.ClsActivitys;
import com.example.fernando.handballdanjoutin.classes.ClsElements;

public class menu extends AppCompatActivity {


    ClsActivitys objetActivitys = new ClsActivitys();
    ClsElements objeElemet = new ClsElements();
    ClsAccionMenu objeAccion = new ClsAccionMenu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        objetActivitys.c = this;
        objeAccion.m = this;
        objeAccion.GetSlidesMenu("photos");

    }


    public void photos(View v) {
        try {
            objetActivitys.Photos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Videos(View v) {
        try {
            objetActivitys.Videos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Club(View v) {
        try {
            objetActivitys.Club();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Contact(View v) {
        try {
            objetActivitys.Contact();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Equipes(View v) {
        try {
            Toast.makeText(this, "Pas disponible", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        try {
            if (objeElemet.tempPremierClick + objeElemet.INTERVALE > System.currentTimeMillis()) {
                finishAffinity();
                return;
            } else {
                objetActivitys.showMensaje("appuyez à nouveau pour sortir");
            }
            objeElemet.tempPremierClick = System.currentTimeMillis();
        } catch (Exception ex) {
            ex.printStackTrace();
            objetActivitys.showMensaje("erreur");
        }
    }
}
