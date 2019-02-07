package com.example.fernando.handballdanjoutin.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernando.handballdanjoutin.Activity.Show_info_salles;
import com.example.fernando.handballdanjoutin.classes.ClsSalles;
import com.example.fernando.handballdanjoutin.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adpSalles extends RecyclerView.Adapter<adpSalles.MyViewHolder> {


    Context c;
    ArrayList<ClsSalles> mData;
    public adpSalles(Context c, ArrayList<ClsSalles> mData){
        this.c = c;
        this.mData = mData;

    }

    @NonNull
    @Override
    public adpSalles.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(R.layout.item_salles, viewGroup, false);
        return new adpSalles.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adpSalles.MyViewHolder myViewHolder, int i) {
        try {
            Picasso.with(c).load(mData.get(i).getImg()).resize(1000,600).into(myViewHolder.img);
            myViewHolder.txtnom.setText(mData.get(i).getNom());
            myViewHolder.btn.setOnClickListener(v -> {
                Intent intent = new Intent(c, Show_info_salles.class);
                intent.putExtra("nom",mData.get(i).getNom());
                intent.putExtra("idclub", mData.get(i).getIdclub());
                intent.putExtra("img", mData.get(i).getImg());
                intent.putExtra("latitud",mData.get(i).getLatitud());
                intent.putExtra("longitud",mData.get(i).getLongitud());
                intent.putExtra("adresse", mData.get(i).getAdresse());
                c.startActivity(intent);
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtnom;
        CardView btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
                img = itemView.findViewById(R.id.img);
                txtnom = itemView.findViewById(R.id.txtnom);
                btn = itemView.findViewById(R.id.btn);


        }
    }
}
