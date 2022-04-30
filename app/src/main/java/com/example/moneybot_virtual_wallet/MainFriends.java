package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainFriends extends AppCompatActivity {

    Bundle extras;

    // model for friends
    ArrayList<friendModel> friendsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_friends);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        // TODO: Display current friends
        // populate card view on friend list
        RecyclerView recyclerView = findViewById(R.id.friends_list_recycler);
        setUpFriendModel();
        friendRecyclerViewAdapter adapter = new friendRecyclerViewAdapter(this, friendsArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

    }// end onCreate

    private void setUpFriendModel(){
        String[] friendsList = {"Leeann W", "Morgan H", "Ian S", "Ann Droid", "Ruby R", "Rust R", "Pearl O", "Swift X"};

        for(int i = 0; i < friendsList.length - 1; i++){
            // init values
            String funds;
            boolean didAccept;

            friendsArrayList.add(new friendModel(friendsList[i], "0", false));
        }// traverse list to populate home list

    }// end setUpTransactionModel

    public void friendOptionsOnClick(View view){
        Intent intent = new Intent(getApplicationContext(), MainMoveFunds.class);
        if (extras != null)
            intent.putExtras(extras);
        startActivity(intent);
    }


}