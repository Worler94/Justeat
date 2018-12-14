package com.example.luca.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SchermatadiBenvenuto extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

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

        text.setOnClickListener(this);

    }
        @Override
        public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){
            if (isChecked) {
                s.getRootView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                s.getRootView().setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{
                text.getText().toString()});
        i.setType("message/rfc822");
        startActivity(i);
    }
}


