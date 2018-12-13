package com.example.luca.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivityRegistrazione extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Attività principale";
    private static final int pass = 6;

    EditText emailRE;
    EditText passwordRE;
    EditText phoneRE;
    Button registerBtnRE;

    boolean emailValidated, passValidated, phoneValidated;
    private boolean hasPaymentMethod() {
        return true;
    }

    private boolean isValidEmail() {
        return !TextUtils.isEmpty(emailRE.getText().toString()) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailRE.getText().toString()).matches();

    }

    private boolean isValidPassword() {
        return (passwordRE.length() > pass);

    }
    private boolean isValidPhone() {
        return (phoneRE.length() > pass);

    }

    private void showErrorMessage(String m) {
        Log.e(TAG, getString(R.string.login_error));
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }

    private void showSuccessMessage(String m) {
        Log.i(TAG, getString(R.string.login_success));
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();

    }

    public void onClick(View v) {
        //fare qualcosa

        if (isValidEmail() && isValidPassword() && isValidPhone()) {
            showSuccessMessage("successo");
        } else {
            showErrorMessage("errore");
        }
    }




    public void enableButton() {
        if ((isValidEmail() && isValidPassword() && isValidPhone())) {
            registerBtnRE.setEnabled(true);
        }
    }
    //TextView Benvenuto = findViewById(R.id.benvenuto);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasto_registrazione);


        emailRE = findViewById(R.id.email_re);
        passwordRE = findViewById(R.id.password_re);
        phoneRE = findViewById(R.id.phone_re);
        registerBtnRE = findViewById(R.id.btn_Register);

        emailRE.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableButton();
            }
        });

        phoneRE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableButton();
            }
        });

        passwordRE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableButton();
            }
        });
    }

    //@Override
    /*public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();


        if (hasPaymentMethod()) {
            registerBtnRE.setVisibility(View.VISIBLE);
        }
        registerBtnRE.setOnClickListener(this);

        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);


    }*/

           /*String mail = getIntent().getStringExtra("benvenuto");
            Benvenuto.setText(getString(R.string.benvenuto)+ " " +mail);*/



}



