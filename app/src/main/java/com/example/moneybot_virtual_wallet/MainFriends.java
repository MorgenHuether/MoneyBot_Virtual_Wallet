package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainFriends extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_friends);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        // TODO: Display current friends
        // TODO: Implement friends search


        // If Home clicked
        Button btnHome = findViewById(R.id.navbtn_Home);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If nav Move Money clicked
        Button btnMove = findViewById(R.id.navbtn_MoveMoney);
        btnMove.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainMoveFunds.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If nav Add Money clicked
        Button btnAdd = findViewById(R.id.navbtn_AddMoney);
        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainAddFunds.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If nav Pay clicked
        Button btnPay = findViewById(R.id.navbtn_Pay);
        btnPay.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainPay.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If nav Settings clicked
        Button btnSettings = findViewById(R.id.navbtn_Settings);
        btnSettings.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if(extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

    }


}