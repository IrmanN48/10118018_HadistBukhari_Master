package com.irman.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class hadistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadist);

        //hide the default action bar
        getSupportActionBar().hide();

        //receive data
        String NoHadist = getIntent().getExtras().getString("no_hadist");
        String Arab = getIntent().getExtras().getString("hadist");
        String terjermahan= getIntent().getExtras().getString("terjermahan");

        //text view

        TextView tv_nohadist = findViewById(R.id.noHadist);
        TextView tv_hadist   = findViewById(R.id.arab);
        TextView tv_terjemahan = findViewById(R.id.terjemahan);


        // set to each to

        tv_nohadist.setText(NoHadist);
        tv_hadist.setText(Arab);
        tv_terjemahan.setText(terjermahan);

    }
}