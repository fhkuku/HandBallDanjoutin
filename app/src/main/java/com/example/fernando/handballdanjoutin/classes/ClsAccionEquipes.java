package com.example.fernando.handballdanjoutin.classes;

import android.support.v7.widget.GridLayoutManager;

import com.example.fernando.handballdanjoutin.Activity.equipes;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adpEquipes;
import com.example.fernando.handballdanjoutin.adapters.adpLiens;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ClsAccionEquipes {

    public equipes objetEquipes;

    ClsElements objetElement = new ClsElements();

    public void GetEquipes() {
        objetElement.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
        objetElement.requestParams = new RequestParams();
        objetElement.requestParams.put("data", "equipes");
        objetElement.asyncHttpClient.post(objetElement.Url + "Request.php", objetElement.requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                objetElement.list = new ArrayList();
                try {
                    objetElement.array = new JSONArray(new String(responseBody));
                    for (int i = 0; i < objetElement.array.length(); i++) {
                        objetElement.row = objetElement.array.getJSONObject(i);
                        objetElement.list.add(new ClsEquipes(objetElement.row.getString("id"), objetElement.row.getString("nom"), objetElement.row.getString("photo")));
                        objetElement.recyclerView = objetEquipes.findViewById(R.id.rcvEquipes);
                        adpEquipes adp = new adpEquipes(objetEquipes, objetElement.list);
                        objetElement.recyclerView.setLayoutManager(new GridLayoutManager(objetEquipes, 1));
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
