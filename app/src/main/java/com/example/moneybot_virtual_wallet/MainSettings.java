package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainSettings extends AppCompatActivity{

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_settings);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        //TODO: update card number and info card
        TextView cardNumBox = findViewById(R.id.dec_CardNum);
        String cardNum = "1111222233334444";            // GET CARD NUM FROM DB
        String formNum = cardNum.substring(0,4) + "-" + cardNum.substring(4,8) + "-" + cardNum.substring(8,12) + "-" + cardNum.substring(12);
        cardNumBox.setText(formNum);

        TextView cardDetBox = findViewById(R.id.dec_CardDetails);
        String cardExp = "1122";                        // GET CARD EXPR FROM DB
        String formExp = cardExp.substring(0,2) + "/" + cardExp.substring(2);
        String cardCCV = "123";                         // GET CARD CCV FROM DB
        String formDet = "Expr: " + formExp + "          CCV: " + cardCCV;
        cardDetBox.setText(formDet);


        // If logout clicked
        Button btnLogout = findViewById(R.id.navbtn_Logout);
        btnLogout.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginLaunch.class);
            // TODO: make sure this is correct way of logging out
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

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

        // If nav Friends clicked
        Button btnFriends = findViewById(R.id.navbtn_Friends);
        btnFriends.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainFriends.class);
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

        // If Add Bank clicked
        Button btnAddBank = findViewById(R.id.btn_AddBank);
        btnAddBank.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BankAdd.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If Edit Info clicked
        Button btnEditInfo = findViewById(R.id.btn_EditInfo);
        btnEditInfo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EditInfo.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });
    }


}