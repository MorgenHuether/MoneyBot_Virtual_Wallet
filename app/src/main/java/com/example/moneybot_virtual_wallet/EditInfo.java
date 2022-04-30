package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.security.NoSuchAlgorithmException;

public class EditInfo extends AppCompatActivity {

    Bundle extras;
    EditText passwordBox, emailBox, phoneBox;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_edit);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();

        // Auto fill with current values
        DB = new DBHelper(this);
        passwordBox = findViewById(R.id.txtIn_Password);
        emailBox = findViewById(R.id.txtIn_Email);
        phoneBox = findViewById(R.id.txtIn_Phone);
        String user = extras.getString("username");
        // Get user data and auto fill form
        String[] userInfo = DB.getUserInfo(user);
        emailBox.setText(userInfo[2]);
        phoneBox.setText(userInfo[3]);


        // If Cancel clicked
        Button btnCancel = findViewById(R.id.btn_Cancel);
        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        // If Update clicked
        Button btnUpdate = findViewById(R.id.btn_Update);
        btnUpdate.setOnClickListener(view -> {

            String newPass = passwordBox.getText().toString();
            String newEmail = emailBox.getText().toString();
            String newPhone = phoneBox.getText().toString();

            if (newPass.equals("")){
                DB.updateUserNotPass(user, DB.getUserInfo(user)[1], newEmail, newPhone);
            }
            else{
                try {
                    DB.updateUserAndPassword(user, newPass, newEmail, newPhone);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
            //TODO: Insert update info DB code


            // Return to settings page
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

    }

}
