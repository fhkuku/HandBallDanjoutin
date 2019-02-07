package com.example.fernando.handballdanjoutin.classes;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.google.android.youtube.player.YouTubePlayerView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClsElements {

    public static final int INTERVALE = 2000;
    public static final String Url = "https://gownetwork.com.mx/webservice/";
    public long tempPremierClick;
    public Window window;
    public SliderLayout sliderLayout;
    public AsyncHttpClient asyncHttpClient;
    public RequestParams requestParams;
    public JSONArray array;
    public JSONObject row;
    public HashMap hashMap;
    public ArrayList list;
    public RecyclerView recyclerView;
    public Context context;
    public List<ClsClub> mData;
    public List<ClsUser> mDataUser;
    public LayoutInflater layoutInflater;
    public View view;
    public Bundle bundle;
    public MapView map;
    public Mapbox mapbox;
    public static String KEY_MAP="pk.eyJ1IjoiZmVybmFuZG9rdWt1IiwiYSI6ImNqcXE2cXNkeTA4ZjUzeG4ydms2cXNtM3YifQ.GHeRI4ufTG9TjkSkP75I6Q";
    public YouTubePlayerView youTubePlayerView;
    public ImageView img;
    public TextView txt, txtAdress;
    public HashMap<String, String> HashMapForURL;
    public CollapsingToolbarLayout collapsingToolbarLayout;

}
