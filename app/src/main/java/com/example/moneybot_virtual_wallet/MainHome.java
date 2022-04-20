package com.example.moneybot_virtual_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainHome extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        // create button click listeners
        Button btnMove = findViewById(R.id.navbtn_MoveMoney);
        btnMove.setOnClickListener(this);
        Button btnAdd = findViewById(R.id.navbtn_AddMoney);
        btnAdd.setOnClickListener(this);
        Button btnFriends = findViewById(R.id.navbtn_Friends);
        btnFriends.setOnClickListener(this);
        Button btnPay = findViewById(R.id.navbtn_Pay);
        btnPay.setOnClickListener(this);
        Button btnSettings = findViewById(R.id.navbtn_Settings);
        btnSettings.setOnClickListener(this);

    }

    // When clicked...
    public void onClick(View view) {
        switch (view.getId()){

            // If MoveMoney nav button was clicked, launch page
            case R.id.navbtn_MoveMoney:
                Intent move = new Intent(this, MainMoveFunds.class);
                startActivity(move);
                break;

            // If AddMoney nav button was clicked, launch page
            case R.id.navbtn_AddMoney:
                Intent add = new Intent(this, MainAddFunds.class);
                startActivity(add);
                break;

            // If Friends nav button was clicked, launch page
            case R.id.navbtn_Friends:
                Intent fri = new Intent(this, MainFriends.class);
                startActivity(fri);
                break;

            // If NFC Pay nav button was clicked, launch page
            case R.id.navbtn_Pay:
                Intent pay = new Intent(this, MainPay.class);
                startActivity(pay);
                break;

            // If Settings nav button was clicked, launch page
            case R.id.navbtn_Settings:
                Intent set = new Intent(this, MainSettings.class);
                startActivity(set);
                break;
            default:
                break;
        }
    }

}