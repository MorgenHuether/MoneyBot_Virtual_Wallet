package com.example.moneybot_virtual_wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainHome extends AppCompatActivity implements View.OnClickListener {

    Bundle extras;

    // model for transactions
    ArrayList<transactionModel> transactionModels = new ArrayList<>();

    // testing data
    String[] test_home_items = {"McDonald's #1234", "Sonic #3300", "Bill Pay ACH", "Netflix", "Murphy's Gas Station", "Cinemark #4522", "Taco Bell #1110", "Shoe Dept #449", "Capital One Autopay", "Bank Deposit"};
    double[] test_home_prices = {12.23,7.56,98.12,22.56,45.12,34.12,12.56,89.34,223.00,-908.12};

    // adapter getItemCount
    int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        // populate card view on home transaction list
        RecyclerView recyclerView = findViewById(R.id.transaction_list);
        setUpTransactionModel();
        transactionRecyclerViewAdapter adapter = new transactionRecyclerViewAdapter(this, transactionModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        size = adapter.getItemCount();

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        if(extras != null) {
            TextView tvWelcome = findViewById(R.id.dec_Title);
            String txt = "Welcome back, " + extras.getString("username");
            SpannableString ss = new SpannableString(txt);
            ForegroundColorSpan fcsHiLite = new ForegroundColorSpan(getResources().getColor(R.color.theme_Orange));
            ss.setSpan(fcsHiLite, "Welcome back, ".length() - 1, txt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tvWelcome.setText(ss);
        }


        // create button click listeners
        Button btnMove = findViewById(R.id.navbtn_MoveMoney);
//        btnMove.setOnClickListener(this);

        btnMove.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainMoveFunds.class);
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

    public void updateTransactionCard(View view){
        // grabbed size of the recycler view to start next index and ending index
        int startingIndex = size;
        int endingIndex = size * 2;

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, "Load more clicked!", duration );
        toast.show();
        // insert functionality for user clicking 'load more'

    }// end updateTransactionCard -- grabs transactions and updates for user on home screen 'card' when 'load more' is pressed

    private void setUpTransactionModel(){
        String[] transactionList = test_home_items;
        double[] transactionPrices = test_home_prices;

        for(int i = 0; i < transactionList.length - 1; i++){ // 0->9 = 10
            // init values
            double balance = 0; // change this to query the current user's balance from db
            boolean isBalNegative = false;
            boolean isDeposit = false;
            int image = 0;

            // check and set for transaction item creation and pop
            if(balance - transactionPrices[i] < 0){
                isBalNegative = true; // set neg flag
            }// check balance -/+
            if(transactionPrices[i] < 0){
                isDeposit = true;
            }// flag deposit

            balance = balance - transactionPrices[i]; // update balance
            transactionModels.add(new transactionModel(transactionList[i],
                    transactionPrices[i], balance, isBalNegative, isDeposit, image));
        }// traverse list to populate home list

    }// end setUpTransactionModel

}// end class