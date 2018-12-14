package com.example.luca.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SchermatadiBenvenuto extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    TextView text;
    Switch s;
    SharedPreferences share;
    SharedPreferences.Editor editor;

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

        share = getPreferences(Context.MODE_PRIVATE);
        editor = share.edit();

        text.setOnClickListener(this);

        s.setChecked(getColorValue());

    }
        @Override
        public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){
            s.getRootView().setBackgroundColor(isChecked ? getResources().getColor(R.color.colorAccent) : getResources().getColor(R.color.colorPrimaryDark));
            setColorValue(isChecked);
        }
        public void setColorValue(boolean value){
            editor.putBoolean("BGcolor", value);
            editor.commit();
        }
        private boolean getColorValue(){
            return share.getBoolean("BGcolor", false);
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


