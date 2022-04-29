package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BankAdd extends AppCompatActivity implements View.OnClickListener{

    Bundle extras;

    EditText bankname, cardholder, account, routing;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_add);

        bankname = findViewById(R.id.txtbx_BankName);
        cardholder = findViewById(R.id.txtbx_CardName);
        account = findViewById(R.id.txtbx_AccountNum);
        routing = findViewById(R.id.txtbx_RoutingNum);
        DB = new DBHelper(this);

        // create button click listeners
        Button btnAdd = findViewById(R.id.btn_AddBank);
//        btnAdd.setOnClickListener(this);

        // If add bank clicked, add to DB and return to home
        btnAdd.setOnClickListener(view -> {
            String bank = bankname.getText().toString();
            String card = cardholder.getText().toString();
            String acc = account.getText().toString();
            String rout = routing.getText().toString();

            // If left blank
            if(bank.equals("")||card.equals("")||acc.equals("")||rout.equals(""))
                Toast.makeText(BankAdd.this, "Missing required information", Toast.LENGTH_SHORT).show();
            else {
                // If db does not already contain account, store new account data
                if(!DB.checkBankAccount(acc))
                    if(DB.insertBankData(bank, card, acc, rout, extras.getString("username"))) {
                        Toast.makeText(BankAdd.this, "Bank added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainSettings.class);
                        if(extras != null)
                            intent.putExtras(extras);
                        startActivity(intent);
                    } else
                        Toast.makeText(BankAdd.this, "Failed to add bank", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(BankAdd.this, "Account already exists", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnCancel = findViewById(R.id.btn_Cancel);
//        btnCancel.setOnClickListener(this);

        // If the cancel button clicked, return to home with no changes
        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
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
