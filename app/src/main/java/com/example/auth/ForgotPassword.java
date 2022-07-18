package com.example.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText edt_email;
    Button btn_get_email;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edt_email=findViewById(R.id.email);
        btn_get_email=findViewById(R.id.get_email);

        firebaseAuth=FirebaseAuth.getInstance();

        btn_get_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetEmail();
            }
        });
    }

    private void GetEmail() {

        String email=edt_email.getText().toString().trim();
        if (email.isEmpty()){
            edt_email.setError("Email is Required ");
            edt_email.requestFocus();
            return;
        }

        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check Email", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ForgotPassword.this, "Try Again ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}