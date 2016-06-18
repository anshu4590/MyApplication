package com.example.shimanhsu4590.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Section extends AppCompatActivity {
    String UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView)findViewById(R.id.TFuserName1);
        tv.setText(username);
    }

    public void NextAct(View view){
        Intent i = new Intent(Section.this,ContinuousCaptureActivity.class);
        startActivity(i);
    }
}
