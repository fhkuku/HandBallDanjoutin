package com.example.fernando.handballdanjoutin.classes;
import android.support.v7.widget.GridLayoutManager;
import com.example.fernando.handballdanjoutin.Activity.show_info;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adpSalles;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ClsAccionSalles {

    ClsElements objetElements = new ClsElements();
    public show_info objetSalles;

    public void GetSalles(String id) {
        try {

            objetElements.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
            objetElements.requestParams = new RequestParams();
            objetElements.requestParams.put("data", "dirigeants");
            objetElements.requestParams .put("id", id);
            objetElements.asyncHttpClient.post(objetElements.Url + "Request.php",objetElements.requestParams, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    ArrayList list = new ArrayList<>();
                    try {
                        JSONArray array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject row = array.getJSONObject(i);
                            list.add(new ClsSalles(row.getString("id"), row.getString("nom"), row.getString("img"), row.getString("latitud"), row.getString("longitud"),row.getString("idclub"), row.getString("adresse")));
                            objetElements.recyclerView = objetSalles.findViewById(R.id.rcvinfo);
                            adpSalles m = new adpSalles(objetSalles, list);
                            objetElements.recyclerView.setLayoutManager(new GridLayoutManager(objetSalles, 1));
                            objetElements.recyclerView.setAdapter(m);
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
