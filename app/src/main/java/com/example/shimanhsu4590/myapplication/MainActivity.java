package com.example.shimanhsu4590.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper;
    EditText a;
    EditText b;
    String str;
    String pass;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DatabaseHelper(this);
        a = (EditText) findViewById(R.id.TFusername);
        b = (EditText) findViewById(R.id.TFpassword);

    }

    public void onButtonClick(View v) {

        switch (v.getId()) {
            case R.id.Blogin:
                str = a.getText().toString();
                pass = b.getText().toString();
                password = helper.searchPass(str);
                if (pass.equals(password)) {
                    Intent i = new Intent(MainActivity.this, Section.class);
                    i.putExtra("Username", str);
                    startActivity(i);
                } else {
                    Toast temp = Toast.makeText(MainActivity.this, "username and passwords don't match", Toast.LENGTH_SHORT);
                    temp.show();
                }
                break;
            case R.id.Bsignup:
                Intent i = new Intent(MainActivity.this, signup.class);
                startActivity(i);
                break;

        }

    }
}







