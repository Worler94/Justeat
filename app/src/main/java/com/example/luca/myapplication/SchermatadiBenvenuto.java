package com.example.luca.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SchermatadiBenvenuto extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    TextView text;
    Switch s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schermatadibenvenuto);

        text = findViewById(R.id.benveuto);

        Intent i = getIntent();

        String a = i.getExtras().getString("welcome");

        text.setText(a);

        s = findViewById(R.id.cambio);

        s.setOnCheckedChangeListener(this);

    }
        @Override
        public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){
            if (isChecked) {
                s.getRootView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                s.getRootView().setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }
    }

