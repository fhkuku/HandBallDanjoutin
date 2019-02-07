package com.example.fernando.handballdanjoutin.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsLiens;
import com.example.fernando.handballdanjoutin.Activity.web_liens;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class adpLiens extends RecyclerView.Adapter<adpLiens.MyViewHolder> {

    Context c;
    List<ClsLiens> mData;

    public adpLiens(Context c, List<ClsLiens> mData){
        this.c = c;
        this.mData = mData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(R.layout.item_liens, viewGroup, false);
        return new adpLiens.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Picasso.with(c).load(mData.get(i).getPhoto()).into(myViewHolder.img);
        myViewHolder.txt.setText(mData.get(i).getNom());
        myViewHolder.btn.setOnClickListener(v -> {
            Intent intent = new Intent(c, web_liens.class);
            intent.putExtra("url", mData.get(i).getUrl());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            c.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView txt;
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txtnom);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
