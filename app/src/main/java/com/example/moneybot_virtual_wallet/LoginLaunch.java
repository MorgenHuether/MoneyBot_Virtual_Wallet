package com.example.moneybot_virtual_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginLaunch extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_launch);

        // create button click listeners
        Button btnLogin = findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(this);
        Button btnCreate = findViewById(R.id.btn_AddBank);
        btnCreate.setOnClickListener(this);
    }

    // When clicked...
    public void onClick(View view) {
        switch (view.getId()){

            // If the login button was clicked, launch login page
            case R.id.btn_Login:
                Intent login = new Intent(this, MainHome.class);
                startActivity(login);
                break;

            // If the create account button was clicked, launch create page
            case R.id.btn_AddBank:
                Intent create = new Intent(this, LoginCreate.class);
                startActivity(create);
                break;
            default:
                break;
        }
    }




}
