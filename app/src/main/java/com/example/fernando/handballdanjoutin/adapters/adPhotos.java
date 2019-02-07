package com.example.fernando.handballdanjoutin.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fernando.handballdanjoutin.classes.ClsPhotos;
import com.example.fernando.handballdanjoutin.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adPhotos extends RecyclerView.Adapter<adPhotos.MyViewHolder> {

    private static Dialog dialog;

    ImageView img;



    Context c;
    List<ClsPhotos> mData;

    public adPhotos(){

    }
    public adPhotos(Context c, List<ClsPhotos> mData){
        this.c = c;
        this.mData = mData;

    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            LayoutInflater layoutInflater = LayoutInflater.from(c);
            View view = layoutInflater.inflate(R.layout.item_photo, viewGroup, false);
            return new adPhotos.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        try {
            Picasso.with(c).load(mData.get(i).getUrl()).resize(1000, 700).into(myViewHolder.imageView);
            img = dialog.findViewById(R.id.img_dialog);

        }catch (Exception e){
            e.printStackTrace();
        }

        myViewHolder.imageView.setOnClickListener(v -> {
            try {
                Picasso.with(c).load(mData.get(i).getUrl()).resize(960, 830).into(img);
                dialog.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return mData.size();
        }catch (Exception e){
            e.printStackTrace();
            return mData.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            try {
                imageView = itemView.findViewById(R.id.imagenfotos);
                dialog = new Dialog(c);
                dialog.setContentView(R.layout.item_dialog_fotos);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }






}
