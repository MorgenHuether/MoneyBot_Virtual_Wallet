package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainPay extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pay);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

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



        // If Home clicked
        Button btnHome = findViewById(R.id.navbtn_Home);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If Move Money clicked
        Button btnMove = findViewById(R.id.navbtn_MoveMoney);
        btnMove.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainMoveFunds.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If Add Money clicked
        Button btnAdd = findViewById(R.id.navbtn_AddMoney);
        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainAddFunds.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If Friends clicked
        Button btnFriends = findViewById(R.id.navbtn_Friends);
        btnFriends.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainFriends.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If Settings clicked
        Button btnSettings = findViewById(R.id.navbtn_Settings);
        btnSettings.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if(extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If Start NFC clicked
        Button btnStartNFC = findViewById(R.id.btn_StartNFC);
        btnStartNFC.setOnClickListener(view -> {
            showNFCPop();
        });
    }

    public void showNFCPop() {
        nfcPopup pop = new nfcPopup();
        pop.show(getSupportFragmentManager(), "nfc");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pop.dismiss();
                Toast.makeText(MainPay.this, "Payment processed successfully.", Toast.LENGTH_SHORT).show();
            }
        }, 3000);


    }

}