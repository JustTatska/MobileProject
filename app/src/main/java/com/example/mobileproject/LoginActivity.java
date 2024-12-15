package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = findViewById(R.id.et_username);
        passwordField = findViewById(R.id.et_password);
        Button loginButton = findViewById(R.id.btn_submit_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndLogin();
            }
        });
    }

    private void validateAndLogin() {
        String username = usernameField.getText().toString().trim();
        String password = passwordField.getText().toString();

        if (username.length() < 2) {
            Toast.makeText(this, "Name must be at least 2 characters long", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isPasswordValid(password)) {
            Toast.makeText(this, "Password must be at least 5 characters long, include 1 uppercase letter and 1 number", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(LoginActivity.this, CongratulationsActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean isPasswordValid(String password) {
        if (password.length() < 5) return false;

        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        return hasUppercase && hasDigit;
    }
}