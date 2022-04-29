package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BankAdd extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_add);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();


        // If add bank clicked, add to DB and return to home
        Button btnAdd = findViewById(R.id.btn_AddBank);
        btnAdd.setOnClickListener(view -> {
            //TODO: add bank information input to DB


            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if(extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });


        // If the cancel button clicked, return to home with no changes
        Button btnCancel = findViewById(R.id.btn_Cancel);
        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if(extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });
    }

}
