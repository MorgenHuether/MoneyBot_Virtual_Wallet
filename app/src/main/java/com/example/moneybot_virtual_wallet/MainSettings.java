package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainSettings extends AppCompatActivity implements View.OnClickListener {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_settings);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        // create button click listeners
        Button btnLogout = findViewById(R.id.navbtn_Logout);
        btnLogout.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginLaunch.class);
            // TODO: make sure this is correct way of logging out
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        Button btnHome = findViewById(R.id.navbtn_Home);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnMove = findViewById(R.id.navbtn_MoveMoney);
        btnMove.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainMoveFunds.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnAdd = findViewById(R.id.navbtn_AddMoney);
        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainAddFunds.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnFriends = findViewById(R.id.navbtn_Friends);
        btnFriends.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainFriends.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnPay = findViewById(R.id.navbtn_Pay);
        btnPay.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainPay.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnAddBank = findViewById(R.id.btn_AddBank);
        btnAddBank.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BankAdd.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnEditInfo = findViewById(R.id.btn_EditInfo);
        btnEditInfo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EditInfo.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });
    }

    // Unused
    public void onClick(View view) {

    }

}