package com.example.fernando.handballdanjoutin.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsPartenaires;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adpPartenaires extends RecyclerView.Adapter<adpPartenaires.MyViewHolder>  {



    Context c;
    List<ClsPartenaires> mData;

    public  adpPartenaires(Context c, List<ClsPartenaires> mData){
        this.c = c;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View view = layoutInflater.inflate(R.layout.item_partanaires, viewGroup, false);
        return new adpPartenaires.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        try {
            myViewHolder.txtnom.setText(mData.get(i).getNom());
            myViewHolder.txtaddresse.setText(mData.get(i).getAddresse());
            myViewHolder.txtphone.setText(mData.get(i).getTelephone());
            Picasso.with(c).load(mData.get(i).getUrl()).into(myViewHolder.img);
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
        TextView txtnom, txtaddresse, txtphone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_publicite);
            txtnom = itemView.findViewById(R.id.txtnom);
            txtaddresse = itemView.findViewById(R.id.txtadresse);
            txtphone = itemView.findViewById(R.id.txtphone);
        }
    }
}
