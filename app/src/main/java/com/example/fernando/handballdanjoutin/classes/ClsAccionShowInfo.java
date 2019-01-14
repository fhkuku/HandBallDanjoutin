package com.example.fernando.handballdanjoutin.classes;

import android.support.v7.widget.GridLayoutManager;

import com.example.fernando.handballdanjoutin.Activity.show_info;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adpShowInfo;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ClsAccionShowInfo {
    public show_info objetInfo;
    ClsElements objetelements = new ClsElements();

    public void GetShowInfo(String data, String id) {

        objetelements.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
        objetelements.requestParams = new RequestParams();
        objetelements.requestParams.put("data", data);
        objetelements.requestParams.put("id", id);
        objetelements.asyncHttpClient.post(objetelements.Url + "Request.php", objetelements.requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                objetelements.list = new ArrayList();
                try {
                    objetelements.array = new JSONArray(new String(responseBody));
                    for (int i = 0; i < objetelements.array.length(); i++) {
                        objetelements.row = objetelements.array.getJSONObject(i);
                        objetelements.list.add(new ClsUser(objetelements.row.getString("id"), objetelements.row.getString("nom"), objetelements.row.getString("img"), objetelements.row.getString("email"), objetelements.row.getString("idtype"), objetelements.row.getString("rol"), objetelements.row.getString("idclub")));
                        objetelements.recyclerView = objetInfo.findViewById(R.id.rcvinfo);
                        adpShowInfo adp = new adpShowInfo(objetInfo, objetelements.list);
                        objetelements.recyclerView.setLayoutManager(new GridLayoutManager(objetInfo, 1));
                        objetelements.recyclerView.setAdapter(adp);


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
