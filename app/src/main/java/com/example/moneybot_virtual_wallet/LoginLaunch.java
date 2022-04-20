package com.example.moneybot_virtual_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginLaunch extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Intent login = new Intent(this, MainHome.class);
        startActivity(login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_launch);

        Button btnLogin = findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(this);
    }

}
