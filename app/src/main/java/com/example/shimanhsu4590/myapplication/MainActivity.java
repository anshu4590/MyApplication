package com.example.shimanhsu4590.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }

    public void onButtonClick(View v) {

        if(v.getId() == R.id.Blogin)
        {
        EditText a = (EditText)findViewById(R.id.TFusername);
        String str = a.getText().toString();

        EditText b = (EditText)findViewById(R.id.TFpassword);
        String pass = b.getText().toString();
        String password =  helper.searchPass(str);
            if (pass.equals(password))
            {
                Intent i = new Intent(MainActivity.this, Section.class);
                i.putExtra("Username",str);
                startActivity(i);

            }
            else
            {
                Toast temp= Toast.makeText(MainActivity.this ,"username and passwords don't match" , Toast.LENGTH_SHORT);
                temp.show();
            }


        Intent i = new Intent(MainActivity.this, Section.class);
        i.putExtra("Username",str);
        startActivity(i);}
        if(v.getId() == R.id.Bsignup)
        {
            Intent i = new Intent(MainActivity.this, signup.class);
            startActivity(i);

        }
    }
}







