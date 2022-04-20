package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMoveFunds extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_movefunds);

        // create button click listeners
        Button btnHome = findViewById(R.id.navbtn_Home);
        btnHome.setOnClickListener(this);
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

            // If Home nav button was clicked, launch page
            case R.id.navbtn_Home:
                Intent home= new Intent(this, MainHome.class);
                startActivity(home);
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
