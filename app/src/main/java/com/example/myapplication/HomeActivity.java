package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView txtEmail;
        Button btnClose;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        txtEmail = findViewById(R.id.nameViewtxt);
        btnClose = findViewById(R.id.btnClose);
        Intent myIntent = getIntent();
        Bundle myBundle = myIntent.getBundleExtra("myPackage");
        String email = myBundle.getString("email");
        txtEmail.setText(email);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close all activities and exit the app
                finishAffinity();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this, "Bạn đã chọn Tìm kiếm", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_share) {
            Toast.makeText(this, "Bạn đã chọn Chia sẻ", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_profile_setting) {
            Toast.makeText(this, "Bạn đã chọn Cài đặt hồ sơ", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Clear the text field
        TextView txtEmail = findViewById(R.id.nameViewtxt);
        txtEmail.setText("");
    }

}