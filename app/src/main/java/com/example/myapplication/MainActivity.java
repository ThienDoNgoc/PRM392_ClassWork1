package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.emailtxt);
        password = findViewById(R.id.passwordtxt);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()) {
                    email.setError("Please enter your email");
                    email.requestFocus();
                    return;
                }
                else if (password.getText().toString().isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                    return;
                }
                if(email.getText().toString().equals("admin") && password.getText().toString().equals("123456")){
                    Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
                    String a = email.getText().toString();
                    Bundle myBundle = new Bundle();
                    myBundle.putString("email", a);
                    myIntent.putExtra("myPackage", myBundle);
                    startActivity(myIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}