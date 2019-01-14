package com.example.fernando.handballdanjoutin.classes;

import android.support.v7.widget.GridLayoutManager;

import com.example.fernando.handballdanjoutin.Activity.club;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adpClub;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ClsAccionClub {

    public club objetclub;
    ClsElements objetElement = new ClsElements();

    public void GetClub(String data) {
        objetElement.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
        objetElement.requestParams = new RequestParams();
        objetElement.requestParams.put("data", data);
        objetElement.asyncHttpClient.post(objetElement.Url + "Request.php", objetElement.requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                objetElement.list = new ArrayList();
                try {
                    objetElement.array = new JSONArray(new String(responseBody));
                    for (int i = 0; i < objetElement.array.length(); i++) {
                        objetElement.row = objetElement.array.getJSONObject(i);
                        objetElement.list.add(new ClsClub(objetElement.row.getString("id"), objetElement.row.getString("img"), objetElement.row.getString("nom")));
                        objetElement.recyclerView = objetclub.findViewById(R.id.rcvclub);
                        adpClub adp = new adpClub(objetclub, objetElement.list);
                        objetElement.recyclerView.setLayoutManager(new GridLayoutManager(objetclub, 1));
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
