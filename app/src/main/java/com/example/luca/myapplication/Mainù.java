package com.example.luca.myapplication;

import android.content.Context;
import android.content.Intent;
//import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;

public class Mainù extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Attività principale";
    private static final String benvenuto = "Ciao";
    private static final int pass = 6;
    private static final String err = "errore";
    private static final String suc = "success";
    EditText emailET;
    EditText passwordET;

    Button loginBtn;
    Button registerBtn;
    EditText phoneRE;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione);


        emailET = findViewById(R.id.email_Et);
        passwordET = findViewById(R.id.password_Et);
        loginBtn = findViewById(R.id.btn_Login);
        registerBtn = findViewById(R.id.btn_Register);
        phoneRE = findViewById(R.id.phone_re);


        if (hasPaymentMethod()) {
            registerBtn.setVisibility(View.VISIBLE);
        }
        registerBtn.setOnClickListener(this);
        //loginBtn.setOnClickListener(this);

        loginBtn.setOnClickListener( s -> {  //s = newonclicklistener
            showSuccessMessage("login effettuato");
        });


    }

    private boolean hasPaymentMethod() {
        return true;
    }


    private boolean isValidEmail() {
        return !TextUtils.isEmpty(emailET.getText().toString()) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailET.getText().toString()).matches();


    }


    private boolean isValidPassword() {
        return passwordET.length() > pass;

    }

    private boolean isValidPhone() {
        return phoneRE.length() > pass;

    }

    private void showErrorMessage(String m) {
        Log.e(TAG, getString(R.string.login_error));
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }

    private void showSuccessMessage(String m) {
        Log.i(TAG, getString(R.string.login_success));
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, SchermatadiBenvenuto.class);
        String mail = emailET.getText().toString();
        i.putExtra("welcome", mail);
        startActivity(i);

    }


   /* private boolean hasPaymentMethod() {
        return true;
    }*/

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_Login) {
            if (isValidPassword() && isValidEmail()) {
                showSuccessMessage(suc);
            } else {
                showErrorMessage(err);
            } Intent i = new Intent(this, SchermatadiBenvenuto.class);
            String s = emailET.getText().toString();
            i.putExtra(benvenuto, s);
            startActivity(i);


        } else if (v.getId() == R.id.btn_Register) {
            Intent i = new Intent(Mainù.this, MainActivityRegistrazione.class);
            this.startActivity(i);

        }

    }
}



      /* if (!isValidEmail()){
           showErrorMessage(getString(R.string.email_error));
       }*/



