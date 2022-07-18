package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);

    }

    public void Login(View view) {

        Intent loginintent=new Intent(getApplicationContext(),Login.class);
        startActivity(loginintent);
    }

    public void Signup(View view) {
        Intent signupIntent=new Intent(getApplicationContext(),signup.class);
        startActivity(signupIntent);
    }
}