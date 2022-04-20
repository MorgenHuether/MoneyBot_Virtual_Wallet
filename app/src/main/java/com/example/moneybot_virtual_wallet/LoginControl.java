package com.example.moneybot_virtual_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginControl extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        // switch to main screen
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_launch);

        Button btnLogin = findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(this);
    }

}
