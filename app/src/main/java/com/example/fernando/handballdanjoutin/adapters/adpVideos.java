package com.example.fernando.handballdanjoutin.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fernando.handballdanjoutin.Activity.videos;
import com.example.fernando.handballdanjoutin.classes.ClsVideos;
import com.example.fernando.handballdanjoutin.R;

import java.util.ArrayList;

public class adpVideos extends RecyclerView.Adapter<adpVideos.MyViewHolder> {

    Context c;
    ArrayList<ClsVideos> mData;

    public adpVideos(Context c, ArrayList<ClsVideos> mData){
        this.c = c;
        this.mData = mData;

    }

    @NonNull
    @Override
    public adpVideos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(R.layout.item_video, viewGroup, false);
        return new adpVideos.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adpVideos.MyViewHolder myViewHolder, int i) {
        myViewHolder.txt.setText(mData.get(i).getTitre());
        myViewHolder.btnvideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, videos.class);
                intent.putExtra("url", mData.get(i).getUrl());
                c.startActivity(intent);
                ((Activity)c).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ConstraintLayout btnvideos;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
            btnvideos = itemView.findViewById(R.id.btnvideos);


        }
    }
}
