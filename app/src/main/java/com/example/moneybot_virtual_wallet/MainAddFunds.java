package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainAddFunds extends AppCompatActivity implements View.OnClickListener {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_addfunds);

        // testing values for the spinner drop-down
        String[] testBanks = {"Bank of America", "Citi", "Capital One", "Swift Cash Android Bank"};
        Spinner spin = (Spinner) findViewById(R.id.drpdwn_FromSource);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, testBanks);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter); // init drop down

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        /// create button click listeners
        Button btnHome = findViewById(R.id.navbtn_Home);
//        btnHome.setOnClickListener(this);

        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnMove = findViewById(R.id.navbtn_MoveMoney);
//        btnMove.setOnClickListener(this);

        btnMove.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainMoveFunds.class);
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

            // If MoveMoney nav button was clicked, launch page
            case R.id.navbtn_MoveMoney:
                Intent move = new Intent(this, MainMoveFunds.class);
                startActivity(move);
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

            // If add money button was clicked, execute method
            case R.id.btn_AddFunds:
                addFunds();
                break;
            default:
                break;
        }
    }

//    @Override
//    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id){
//
//    }// end onItemSelected --

    // adds funds to the account
    private void addFunds(){
        // Helpful variables
        View from = findViewById(R.id.drpdwn_FromSource); // drop down selection
        View amount = findViewById(R.id.txtbx_Amount); // entered amount to add



    }

}
