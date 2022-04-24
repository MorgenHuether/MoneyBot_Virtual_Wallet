package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMoveFunds extends AppCompatActivity implements View.OnClickListener{

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_movefunds);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        // create button click listeners
        Button btnHome = findViewById(R.id.navbtn_Home);
//        btnHome.setOnClickListener(this);

        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnAdd = findViewById(R.id.navbtn_AddMoney);
//        btnAdd.setOnClickListener(this);

        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainAddFunds.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnFriends = findViewById(R.id.navbtn_Friends);
//        btnFriends.setOnClickListener(this);

        btnFriends.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainFriends.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnPay = findViewById(R.id.navbtn_Pay);
//        btnPay.setOnClickListener(this);

        btnPay.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainPay.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnSettings = findViewById(R.id.navbtn_Settings);
        //btnSettings.setOnClickListener(this);

        btnSettings.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if(extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

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

            // If transfer money button was clicked, execute transfer method
            case R.id.btn_Transfer:
                transferFunds();
                break;
            default:
                break;
        }
    }

    // transfers funds from one user to another
    private void transferFunds(){
        // Useful variables
        View recipient = findViewById(R.id.drpdwn_Recipient);
        View amount = findViewById(R.id.txtbx_Amount);

        //TODO: Finish the Transfer Funds method
    }


}
