package com.example.fernando.handballdanjoutin.classes;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.fernando.handballdanjoutin.Activity.menu;
import com.example.fernando.handballdanjoutin.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class ClsAccionMenu {

    public menu m;
    ClsElements objeElements = new ClsElements();

    public void SetSliderMenu(HashMap<String, String> HashMapForURL) {
        objeElements.sliderLayout = m.findViewById(R.id.slider);
        try {
            for (String name : HashMapForURL.keySet()) {
                TextSliderView textSliderView = new TextSliderView(m);
                textSliderView
                        .description(name)
                        .image(HashMapForURL.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);
                objeElements.sliderLayout.addSlider(textSliderView);
            }
            objeElements.sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
            objeElements.sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            objeElements.sliderLayout.setCustomAnimation(new DescriptionAnimation());
            objeElements.sliderLayout.setDuration(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetSlidesMenu(String data) {
        try {
            objeElements.asyncHttpClient = new AsyncHttpClient(true, 80, 443);
            objeElements.requestParams = new RequestParams();
            objeElements.requestParams.put("data", data);
            objeElements.asyncHttpClient.post(objeElements.Url + "Request.php", objeElements.requestParams, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        objeElements.array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < objeElements.array.length(); i++) {
                            objeElements.row = objeElements.array.getJSONObject(i);
                            String url = objeElements.row.getString("url");
                            String description = objeElements.row.getString("description");
                            objeElements.hashMap = new HashMap<>();
                            objeElements.hashMap.put(description, url);
                            SetSliderMenu(objeElements.hashMap);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
