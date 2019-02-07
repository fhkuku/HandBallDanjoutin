package com.example.fernando.handballdanjoutin.classes;

import android.support.v7.widget.GridLayoutManager;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.fernando.handballdanjoutin.Activity.photos;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.adapters.adPhotos;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class ClsAccionPhotos implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener  {

    ClsElements e = new ClsElements();
    public photos objetPhotos;
    public SliderLayout sliderLayout;

    public void GetPhotos() {
        try {
            AsyncHttpClient client = new AsyncHttpClient(true, 80, 443);
            e.requestParams = new RequestParams();
            e.requestParams.put("data", "photos");
            client.post(e.Url + "Request.php", e.requestParams , new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    ArrayList list = new ArrayList<>();
                    try {
                        JSONArray array = new JSONArray(new String(responseBody));
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject row = array.getJSONObject(i);
                            e.HashMapForURL = new HashMap<>();
                            e.HashMapForURL.put(row.getString("description"), row.getString("url"));
                            Slider(e.HashMapForURL);
                            list.add(new ClsPhotos(row.getString("id"), row.getString("url")));
                            e.recyclerView = objetPhotos.findViewById(R.id.rcvphotos);
                            adPhotos m = new adPhotos(objetPhotos, list);
                            e.recyclerView.setLayoutManager(new GridLayoutManager(objetPhotos, 2));
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


    public void Slider(HashMap<String, String> HashMapForURL){
        try {
            sliderLayout = objetPhotos.findViewById(R.id.sliderphotos);
            for (String name : HashMapForURL.keySet()) {
                TextSliderView textSliderView = new TextSliderView(objetPhotos);
                textSliderView
                        .description(name)
                        .image(HashMapForURL.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);
                sliderLayout.addSlider(textSliderView);
            }
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
