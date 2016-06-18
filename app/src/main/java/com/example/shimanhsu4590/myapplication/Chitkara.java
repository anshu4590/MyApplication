package com.example.shimanhsu4590.myapplication;

/**
 * Created by shimanhsu4590 on 6/18/2016.
 */
public class Chitkara {
    String name, email, uname, pass;

    public void setName(String name) {this.name = name;}

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return this.uname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return this.pass;
    }

    @Override
    public String toString() {

        return "name = "+ name + " email = " + email + " uname = " + uname + " password  = " + pass;
    }
}
