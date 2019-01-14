package com.example.fernando.handballdanjoutin.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.fernando.handballdanjoutin.R;
import com.ramotion.foldingcell.FoldingCell;

public class photos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);


        final FoldingCell fc2 = findViewById(R.id.folding_cell2);
        fc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fc2.initialize(50, 1000, Color.WHITE, 2);
                fc2.toggle(false);
            }
        });


    }
}
