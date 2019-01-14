package com.example.fernando.handballdanjoutin.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernando.handballdanjoutin.Activity.show_info;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsClub;
import com.example.fernando.handballdanjoutin.classes.ClsElements;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adpClub extends RecyclerView.Adapter<adpClub.MyViewHolder> {

    ClsElements objetElements = new ClsElements();


    public adpClub(Context c, List<ClsClub> mData) {
        objetElements.context = c;
        objetElements.mData = mData;

    }

    @NonNull
    @Override
    public adpClub.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        objetElements.layoutInflater = LayoutInflater.from(objetElements.context);
        objetElements.view = objetElements.layoutInflater.inflate(R.layout.item_club, viewGroup, false);
        return new adpClub.MyViewHolder(objetElements.view);

    }

    @Override
    public void onBindViewHolder(@NonNull adpClub.MyViewHolder holder, final int i) {
        Picasso.with(objetElements.context).load(objetElements.mData.get(i).getUrl()).resize(890, 750).into(holder.img);
        holder.txt.setText(objetElements.mData.get(i).getNom());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(objetElements.context, show_info.class);
                intent.putExtra("id", objetElements.mData.get(i).getIdclub());
                objetElements.context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return objetElements.mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgclub);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}
