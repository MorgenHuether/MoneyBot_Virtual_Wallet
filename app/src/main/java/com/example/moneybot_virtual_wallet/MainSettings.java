package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainSettings extends AppCompatActivity{

    Bundle extras;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_settings);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();
        String user = extras.getString("username");
        DB = new DBHelper(this);

        //TODO: Display card number and info (the commented stuff)

        // Print card number in standard format
        TextView cardNumBox = findViewById(R.id.dec_CardNum);
        //String cardNum = DB.getCard(user).getCardNumber();
        //String formNum = cardNum.substring(0,4) + "-" + cardNum.substring(4,8) + "-" + cardNum.substring(8,12) + "-" + cardNum.substring(12);
        //cardNumBox.setText(formNum);
        // Print card CVV and Exp in standard format
        TextView cardDetBox = findViewById(R.id.dec_CardDetails);
        //String cardExp = DB.getCard(user).getExpiration();
        //String cardCCV = DB.getCard(user).getCvv();
        //String formDet = "Expr: " + cardExp + "      CCV: " + cardCCV;
        //cardDetBox.setText(formDet);


        // If logout clicked
        Button btnLogout = findViewById(R.id.navbtn_Logout);
        btnLogout.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginLaunch.class);
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