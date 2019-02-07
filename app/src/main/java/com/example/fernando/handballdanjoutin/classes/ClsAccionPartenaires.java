package com.example.fernando.handballdanjoutin.classes;
import android.support.v7.widget.GridLayoutManager;
import com.example.fernando.handballdanjoutin.Activity.Partanaires;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adpPartenaires;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ClsAccionPartenaires {


    ClsElements objetelements = new ClsElements();
    public Partanaires objetPartenaires;


    adpPartenaires m;
    public void GetShowPatenaires() {
        objetelements.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
        objetelements.requestParams = new RequestParams();
        objetelements.requestParams.put("data", "parteinaires");
        objetelements.asyncHttpClient.post(objetelements.Url + "Request.php", objetelements.requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                objetelements.list = new ArrayList();
                try {
                    objetelements.array = new JSONArray(new String(responseBody));
                    for (int i = 0; i < objetelements.array.length(); i++) {
                        objetelements.row = objetelements.array.getJSONObject(i);
                        objetelements.list.add(new ClsPartenaires(objetelements.row.getString("nom"), objetelements.row.getString("addresse"), objetelements.row.getString("tel"), objetelements.row.getString("url"), objetelements.row.getString("id")));
                        objetelements.recyclerView = objetPartenaires.findViewById(R.id.rcvPartanaires);
                        m = new adpPartenaires(objetPartenaires, objetelements.list);
                    }
                    objetelements.recyclerView.setLayoutManager(new GridLayoutManager(objetPartenaires, 2));
                    objetelements.recyclerView.setAdapter(m);

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
