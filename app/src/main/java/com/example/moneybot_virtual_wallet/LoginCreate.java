package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginCreate extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_create);

        // create button click listeners
        Button btnCreate = findViewById(R.id.btn_CreateAcc);
        btnCreate.setOnClickListener(this);
        Button btnCancel = findViewById(R.id.btn_Cancel);
        btnCancel.setOnClickListener(this);
    }

    // When clicked...
    public void onClick(View view) {
        switch (view.getId()){

            // If the create account clicked, check info and return to login page
            case R.id.btn_CreateAcc:
                Intent login = new Intent(this, LoginLaunch.class);
                startActivity(login);
                break;

            // If the cancel button clicked, return to login launch with no changes
            case R.id.btn_Cancel:
                Intent create = new Intent(this, LoginLaunch.class);
                startActivity(create);
                break;
            default:
                break;
        }
    }
}
