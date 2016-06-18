package com.example.shimanhsu4590.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper;
    EditText tvUsername;
    EditText tvPassword;
    String str;
    String password;
    boolean confirmPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DatabaseHelper(this);
        tvUsername = (EditText) findViewById(R.id.TFusername);
        tvPassword = (EditText) findViewById(R.id.TFpassword);

    }

    public void onButtonClick(View v) {

        switch (v.getId()) {
            case R.id.Blogin:
                confirmPassword = helper.matchPassword(tvUsername.getText().toString(),tvPassword.getText().toString());
                Log.e("1334",String.valueOf(confirmPassword));
                if (confirmPassword) {
                    Intent i = new Intent(MainActivity.this, Section.class);
                    i.putExtra("Username",tvUsername.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "username and passwords is incorrect", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.Bsignup:
                Intent i = new Intent(MainActivity.this, signup.class);
                startActivity(i);
                break;

        }

    }
}







