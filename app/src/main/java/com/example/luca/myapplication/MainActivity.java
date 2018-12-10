package com.example.luca.myapplication;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG  = "mainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "activity created");
}


    @Override
    protected void onStart (){
        super.onStart();
        Log.i(TAG, "activity created");
    }
    @Override
    protected void onResume (){
        super.onResume();

    }
    @Override
    protected void onPause (){
        super.onPause();

    }
    @Override
    protected void onStop (){
        super.onStop();

    }
    @Override
    protected void onDestroy (){
        super.onDestroy();
    }

}
