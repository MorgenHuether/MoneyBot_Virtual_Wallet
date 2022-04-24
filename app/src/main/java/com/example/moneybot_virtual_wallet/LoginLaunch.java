package com.example.moneybot_virtual_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginLaunch extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_launch);

        username = findViewById(R.id.txtIn_Username);
        password = findViewById(R.id.txtIn_Password);
        DB = new DBHelper(this);

        // create button click listeners
        Button btnLogin = findViewById(R.id.btn_Login);
        // btnLogin.setOnClickListener(this);

        // onClick without needing switch case
        btnLogin.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(user.equals("")||pass.equals(""))
                Toast.makeText(LoginLaunch.this, "Username and/or Password is missing", Toast.LENGTH_SHORT).show();
            else {
                // Hashed password after checking if username/password missing
                String hashedPass = hash(user + pass);
                // If username and password correct, login and go to home
                if(DB.checkUsernamePass(user, hashedPass)) {
                    Intent login = new Intent(getApplicationContext(), MainHome.class);
                    startActivity(login);
                } else {
                    Toast.makeText(LoginLaunch.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }

        });

        Button btnCreate = findViewById(R.id.btn_CreateAcc);
        //btnCreate.setOnClickListener(this);

        // If the create account button was clicked, launch create page
        btnCreate.setOnClickListener(view -> {
            Intent create = new Intent(getApplicationContext(), LoginCreate.class);
            startActivity(create);
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

            // If the login button was clicked, launch login page
            case R.id.btn_Login:
                Intent login = new Intent(this, MainHome.class);
                startActivity(login);
                break;

            // If the create account button was clicked, launch create page
            case R.id.btn_CreateAcc:
                Intent create = new Intent(this, LoginCreate.class);
                startActivity(create);
                break;
            default:
                break;
        }
    }




}
