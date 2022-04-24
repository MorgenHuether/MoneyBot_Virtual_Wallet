package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginCreate extends AppCompatActivity implements View.OnClickListener{

    EditText username, password, email, phone;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_create);

        username = findViewById(R.id.txtIn_Username);
        password = findViewById(R.id.txtIn_Password);
        email = findViewById(R.id.txtIn_Email);
        phone = findViewById(R.id.txtIn_Phone);
        DB = new DBHelper(this);

        // create button click listeners
        Button btnCreate = findViewById(R.id.btn_CreateAcc);
        //btnCreate.setOnClickListener(this);

        // onClick without needing switch case
        btnCreate.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String eml = email.getText().toString();
            String pho = phone.getText().toString();

            // If field left blank
            if(user.equals("")||pass.equals("")||eml.equals("")||pho.equals(""))
                Toast.makeText(LoginCreate.this, "Missing required information", Toast.LENGTH_SHORT).show();
            else {
                // Hash password after checking if field empty
                String hashedPass = hash(user + pass);

                // If database does not already contain username and email, store new user data
                if(!DB.checkUsername(user) && !DB.checkEmail(eml))
                    if (DB.insertData(user, hashedPass, eml, pho)) {
                        Toast.makeText(LoginCreate.this, "Account creation successful", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(getApplicationContext(), LoginLaunch.class);
                        startActivity(login);
                    } else
                        Toast.makeText(LoginCreate.this, "Account creation failed", Toast.LENGTH_SHORT).show();
                else {
                    if(DB.checkUsername(user) && DB.checkEmail(eml))
                        Toast.makeText(LoginCreate.this, "Username and Email already taken", Toast.LENGTH_SHORT).show();
                    else if(DB.checkUsername(user))
                        Toast.makeText(LoginCreate.this, "Username already taken", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(LoginCreate.this, "Email already in use", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnCancel = findViewById(R.id.btn_Cancel);
//        btnCancel.setOnClickListener(this);

        // If the cancel button clicked, return to login launch with no changes
        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginLaunch.class);
            startActivity(intent);
        });
    }

    String hash(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(pass.getBytes());
            byte[] arr = md.digest();
            StringBuilder sb = new StringBuilder();
            for(byte b: arr)
                sb.append(Integer.toHexString(b & 0xFF));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // When clicked...  -- Note: not used after db implementation
    public void onClick(View view) {
        switch (view.getId()){

            // If the create account clicked, check info and return to login page
            case R.id.btn_CreateAcc:
                Intent login = new Intent(this, LoginLaunch.class);
                startActivity(login);
                break;

            // If the cancel button clicked, return to login launch with no changes
            case R.id.btn_Cancel:
                Intent create = new Intent(this, LoginLaunch.class);
                startActivity(create);
                break;
            default:
                break;
        }
    }
}
