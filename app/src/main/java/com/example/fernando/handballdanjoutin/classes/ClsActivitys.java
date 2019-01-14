package com.example.fernando.handballdanjoutin.classes;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.fernando.handballdanjoutin.Activity.club;
import com.example.fernando.handballdanjoutin.Activity.contact;
import com.example.fernando.handballdanjoutin.Activity.menu;
import com.example.fernando.handballdanjoutin.Activity.photos;
import com.example.fernando.handballdanjoutin.Activity.videos;


public class ClsActivitys {

    public Context c;

    public void Photos() {

        try {
            Intent intent = new Intent(c, photos.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            c.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Menu() {
        try {
            Intent intent = new Intent(c, menu.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            c.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Videos() {
        try {
            Intent intent = new Intent(c, videos.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            c.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Club() {
        try {
            Intent intent = new Intent(c, club.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            c.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Contact() {
        try {
            Intent intent = new Intent(c, contact.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            c.startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showMensaje(String texto) {
        Toast.makeText(c, texto, Toast.LENGTH_SHORT).show();
    }


}

