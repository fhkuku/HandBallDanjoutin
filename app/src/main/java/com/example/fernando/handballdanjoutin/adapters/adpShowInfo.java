package com.example.fernando.handballdanjoutin.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsElements;
import com.example.fernando.handballdanjoutin.classes.ClsUser;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class adpShowInfo extends RecyclerView.Adapter<adpShowInfo.MyViewHolder> {


    ClsElements objetElements = new ClsElements();


    public adpShowInfo(Context c, List<ClsUser> mData) {
        objetElements.context = c;
        objetElements.mDataUser = mData;

    }


    @NonNull
    @Override
    public adpShowInfo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        objetElements.layoutInflater = LayoutInflater.from(objetElements.context);
        objetElements.view = objetElements.layoutInflater.inflate(R.layout.item_info, viewGroup, false);
        return new adpShowInfo.MyViewHolder(objetElements.view);
    }

    @Override
    public void onBindViewHolder(@NonNull final adpShowInfo.MyViewHolder myViewHolder, int i) {


        Picasso.with(objetElements.context).load(objetElements.mDataUser.get(i).getImg()).into(myViewHolder.img);
        Picasso.with(objetElements.context).load(objetElements.mDataUser.get(i).getImg()).into(myViewHolder.img2);
        myViewHolder.txtnom.setText(objetElements.mDataUser.get(i).getNom());
        myViewHolder.txtnom2.setText(objetElements.mDataUser.get(i).getNom());
        myViewHolder.txtrol.setText(objetElements.mDataUser.get(i).getRol());
        myViewHolder.f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewHolder.f.initialize(30, 1000, Color.DKGRAY, 2);
                myViewHolder.f.toggle(false);

                myViewHolder.img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(objetElements.context, "Hola", Toast.LENGTH_LONG).show();
                    }
                });

                myViewHolder.img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(objetElements.context, "Hola", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return objetElements.mDataUser.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        FoldingCell f;
        CircleImageView img, img2;
        TextView txtnom, txtnom2, txtrol;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            f = itemView.findViewById(R.id.btnSelect);
            img = itemView.findViewById(R.id.img);
            img2 = itemView.findViewById(R.id.img2);
            txtnom = itemView.findViewById(R.id.txtnom);
            txtnom2 = itemView.findViewById(R.id.txtnom2);
            txtrol = itemView.findViewById(R.id.txtrol);
        }
    }
}
