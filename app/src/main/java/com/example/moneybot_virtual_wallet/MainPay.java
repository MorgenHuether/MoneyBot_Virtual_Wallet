package com.example.moneybot_virtual_wallet;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainPay extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pay);

        // create button click listeners
        Button btnHome = findViewById(R.id.navbtn_Home);
        btnHome.setOnClickListener(this);
        Button btnMove = findViewById(R.id.navbtn_MoveMoney);
        btnMove.setOnClickListener(this);
        Button btnAdd = findViewById(R.id.navbtn_AddMoney);
        btnAdd.setOnClickListener(this);
        Button btnFriends = findViewById(R.id.navbtn_Friends);
        btnFriends.setOnClickListener(this);
        Button btnSettings = findViewById(R.id.navbtn_Settings);
        btnSettings.setOnClickListener(this);
        Button btnNFCStart = findViewById(R.id.btn_StartNFC);
        btnNFCStart.setOnClickListener(this);

    }

    // When clicked...
    public void onClick(View view) {
        switch (view.getId()){

            // If Home nav button was clicked, launch page
            case R.id.navbtn_Home:
                Intent home= new Intent(this, MainHome.class);
                startActivity(home);
                break;

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

            // If Settings nav button was clicked, launch page
            case R.id.navbtn_Settings:
                Intent set = new Intent(this, MainSettings.class);
                startActivity(set);
                break;

            // If NFC pay button was clicked, show NFC popup
            case R.id.btn_StartNFC:

                // TODO: display popup for NFC "nfc_paypopup.xml"

                break;
            default:
                break;
        }
    }

}