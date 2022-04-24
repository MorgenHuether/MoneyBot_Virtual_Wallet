package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BankAdd extends AppCompatActivity implements View.OnClickListener{

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_add);

        // create button click listeners
        Button btnAdd = findViewById(R.id.btn_AddBank);
//        btnAdd.setOnClickListener(this);

        // If add bank clicked, add to DB and return to home
        btnAdd.setOnClickListener(view -> {
            //TODO: add bank information input to DB


            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            if(extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        Button btnCancel = findViewById(R.id.btn_Cancel);
//        btnCancel.setOnClickListener(this);

        // If the cancel button clicked, return to home with no changes
        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            if(extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });
    }

    // When clicked...
    public void onClick(View view) {
        switch (view.getId()){

            // If add bank clicked, add to DB and return to home
            case R.id.btn_AddBank:
                //TODO: add bank information input to DB
                Intent login = new Intent(this, MainHome.class);
                startActivity(login);
                break;

            // If the cancel button clicked, return to home with no changes
            case R.id.btn_Cancel:
                Intent create = new Intent(this, MainHome.class);
                startActivity(create);
                break;
            default:
                break;
        }
    }
}
