package com.example.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    EditText edit_name,edit_email,edit_password,edit_CPassword;
    Button btn_Signup;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edit_name=findViewById(R.id.edit);
        edit_email=findViewById(R.id.edit1);
        edit_password=findViewById(R.id.edit2);
        edit_CPassword=findViewById(R.id.edit3);

        btn_Signup=findViewById(R.id.btn1);
        firebaseAuth=FirebaseAuth.getInstance();

        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edit_email.getText().toString().trim();
                String password=edit_password.getText().toString().trim();
                String confirmpassword=edit_CPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(confirmpassword)){
                    Toast.makeText(signup.this, "Please Enter ConfirmPassword", Toast.LENGTH_SHORT).show();
                }
                if (password.length()<6){
                    Toast.makeText(signup.this, "Password Too Short ", Toast.LENGTH_SHORT).show();
                }
                if (confirmpassword.equals(password)){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent signupIntent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(signupIntent);
                                Toast.makeText(signup.this, "Signup Complete", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(signup.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
}