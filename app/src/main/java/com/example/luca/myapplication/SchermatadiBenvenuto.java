package com.example.luca.myapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SchermatadiBenvenuto extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    Button plus1, plus2, plus3, minus1, minus2, minus3, buy, euro;
    TextView num1, num2, num3;
    TextView text;
    Switch s;
    SharedPreferences share;
    SharedPreferences.Editor editor;
    double total;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    private String result;
    //JSONObject jObject = new JSONObject(result);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schermatadibenvenuto);

        plus1 = findViewById(R.id.plus1);
        /*plus2 = findViewById(R.id.plus2);
        plus3 = findViewById(R.id.plus3);*/
        minus1 = findViewById(R.id.minus1);
       /* minus2 = findViewById(R.id.minus2);
        minus3 = findViewById(R.id.minus3);*/
        buy = findViewById(R.id.buy);
        euro = findViewById(R.id.euro);
        num1 = findViewById(R.id.num1);
        /*num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);*/

        text = findViewById(R.id.benvenuto);

        Intent i = getIntent();

        String a = i.getExtras().getString("welcome");

        text.setText(a);

        s = findViewById(R.id.cambio);

        s.setOnCheckedChangeListener(this);

        share = getPreferences(Context.MODE_PRIVATE);
        editor = share.edit();

        text.setOnClickListener(this);

        s.setChecked(getColorValue());

        recyclerView = findViewById(R.id.recycleView);
        ArrayList<Food> data = new ArrayList<>();
        adapter = new RowAdapter(this, data);



    }
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()){
        @Override
        public void OnResponse(String response){
            log.d("Success", response);
            try{
                JSONArray responseJSON = new JSONArray(response);
                ArrayList<Food> foodArrayList = new ArrayList<>();

                for (int i=0; i<responseJSON.length(); i++){
                    Food food = new Food(responseJSON.getJSONObject(i));
                    foodArrayList.add(food);
                }
                adapter.setData(foodArrayList);
            }
            catch (JSONException e){
                e.printStackTrace();
                Toast.makeText(SchermatadiBenvenuto.this, "Qualcosa è andato storto", Toast.LENGTH_LONG).show();
            }
        }
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

        public void setPlus1(int btn){
            plus1.setInputType(1);
        }
        public int getPlus1(){
            return plus1.getInputType();
        }
        public int num1(){
            return getPlus1();
        }
        public void setPlus2(int btn){
            plus2.setInputType(1);
        }
        public int getPlus2(){
            return plus2.getInputType();
    }
        public int num2(){
            return getPlus2();
    }
        public void setPlus3(int btn){
            plus1.setInputType(1);
    }
        public int getPlus3(){
            return plus1.getInputType();
    }
        public int num3(){
            return getPlus3();
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


