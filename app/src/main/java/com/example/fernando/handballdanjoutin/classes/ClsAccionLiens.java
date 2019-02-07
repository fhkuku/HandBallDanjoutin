package com.example.fernando.handballdanjoutin.classes;

import android.support.v7.widget.GridLayoutManager;

import com.example.fernando.handballdanjoutin.Activity.liens;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adpClub;
import com.example.fernando.handballdanjoutin.adapters.adpLiens;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ClsAccionLiens {

    public liens objetlien;
    ClsElements objetElement = new ClsElements();

    public void GetLiens() {
        objetElement.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
        objetElement.requestParams = new RequestParams();
        objetElement.requestParams.put("data", "liens");
        objetElement.asyncHttpClient.post(objetElement.Url + "Request.php", objetElement.requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                objetElement.list = new ArrayList();
                try {
                    objetElement.array = new JSONArray(new String(responseBody));
                    for (int i = 0; i < objetElement.array.length(); i++) {
                        objetElement.row = objetElement.array.getJSONObject(i);
                        objetElement.list.add(new ClsLiens(objetElement.row.getString("id"), objetElement.row.getString("url"), objetElement.row.getString("nom"),objetElement.row.getString("photo")));
                        objetElement.recyclerView = objetlien.findViewById(R.id.rcvLiens);
                        adpLiens adp = new adpLiens(objetlien, objetElement.list);
                        objetElement.recyclerView.setLayoutManager(new GridLayoutManager(objetlien, 2));
                        objetElement.recyclerView.setAdapter(adp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


    }




}
