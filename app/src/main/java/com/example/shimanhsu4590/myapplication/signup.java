package com.example.shimanhsu4590.myapplication;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class signup extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.Bsignupbutton)
        {
            EditText name= (EditText)findViewById(R.id.TFname);
            EditText email= (EditText)findViewById(R.id.TFemail);
            EditText uname= (EditText)findViewById(R.id.TFuname);
            EditText pass1= (EditText)findViewById(R.id.TFpass1);
            EditText pass2= (EditText)findViewById(R.id.TFpass2);
            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if (!pass1str.equals(pass2str))
            {//popup msg
                Toast pass= Toast.makeText(signup.this ,"passwords don't match" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {//insert the details in database
                Chitkara c= new Chitkara();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUnameame(unamestr);
                c.setPass(pass1str);
                helper.insertchitkara(c);

            }
        }
    }

}
