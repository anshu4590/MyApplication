package com.example.shimanhsu4590.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText userName;
    EditText emailId;
    EditText studentName;
    EditText password;
    EditText confirmPassword;
    DatabaseHelper helper;
    Chitkara studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        helper = new DatabaseHelper(this);
        studentName = (EditText) findViewById(R.id.TFname);
        emailId = (EditText) findViewById(R.id.TFemail);
        userName = (EditText) findViewById(R.id.TFuserName);
        password = (EditText) findViewById(R.id.TFpassword);
        confirmPassword = (EditText) findViewById(R.id.TFconfirmPassword);
    }

    public void onSignUpClick(View v) {
        if (v.getId() == R.id.Bsignupbutton) {
            if(!fieldIsEmpty()){
                Toast.makeText(getApplicationContext(), "Some field are empty", Toast.LENGTH_SHORT).show();
            }
            if (matchPassword()) {
                studentInfo = new Chitkara();
                studentInfo.setName(studentName.getText().toString());
                studentInfo.setEmail(emailId.getText().toString());
                studentInfo.setUname(userName.getText().toString());
                studentInfo.setPass(password.getText().toString());
                Log.e("studentInfo",studentInfo.toString() + "\n" + userName.getText().toString());
                helper.insertStudentInfo(studentInfo);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Password do not Match", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean matchPassword() {
        return password.getText().toString().equals(confirmPassword.getText().toString());
    }

    public boolean fieldIsEmpty() {
        if (studentName.getText().toString().equals(null))
            return false;
        else if (emailId.getText().toString().equals(null))
            return false;
        else if (userName.getText().toString().equals(null))
            return false;
        else if (password.getText().toString().equals(null))
            return false;
        else if (confirmPassword.getText().toString().equals(null))
            return false;
        return true;
    }

}
