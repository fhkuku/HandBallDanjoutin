package com.example.fernando.handballdanjoutin.classes;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.fernando.handballdanjoutin.Activity.videos;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adpVideos;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class ClsAccionVideo {
    ClsElements e = new ClsElements();
    public videos objetVideo;


    public void GetVideos() {
        try {
            e.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
            e.requestParams = new RequestParams();
            e.requestParams.put("data", "videos");
            e.asyncHttpClient.post(e.Url + "Request.php",e.requestParams, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    ArrayList list = new ArrayList<>();
                    String valor = new String(responseBody);
                    try {
                        JSONArray array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject row = array.getJSONObject(i);
                            list.add(new ClsVideos(row.getString("id"), row.getString("url"), row.getString("titre")));
                            e.recyclerView = objetVideo.findViewById(R.id.rcvideos);
                            adpVideos m = new adpVideos(objetVideo, list);
                            e.recyclerView.setLayoutManager(new GridLayoutManager(objetVideo, 1));
                            e.recyclerView.setAdapter(m);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
