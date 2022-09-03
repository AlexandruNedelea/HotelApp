package com.example.licenta2022;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.databinding.ActivityAutentificationEmployeeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AutentificationEmployeeActivity extends BaseActivity<ActivityAutentificationEmployeeBinding> {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityAutentificationEmployeeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setListeners();
    }

    private void setListeners() {
        dataBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithEmailAndPassword();
            }
        });
    }

    private void loginWithEmailAndPassword() {
        var email = dataBinding.etLoginEmail.getText().toString();
        var password = dataBinding.etLoginPassword.getText().toString();
        if (email.isEmpty()) {
            Toast.makeText(this, "Email can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            onAuthSuccess();
                        } else {
                            Toast.makeText(AutentificationEmployeeActivity.this,
                                    "Password must have at least 6 characters", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onAuthSuccess() {
        startActivity(new Intent(this, EmployeeActivity.class));
    }
}