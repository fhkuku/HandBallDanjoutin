package com.example.fernando.handballdanjoutin.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fernando.handballdanjoutin.R;
import com.example.fernando.handballdanjoutin.classes.ClsAccionPartenaires;

public class Partanaires extends AppCompatActivity {


    ClsAccionPartenaires objetAction = new ClsAccionPartenaires();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partanaires);
        this.setTitle("Partenaires");
        objetAction.objetPartenaires = this;
        objetAction.GetShowPatenaires();


    }
}
