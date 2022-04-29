package com.example.moneybot_virtual_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginLaunch extends AppCompatActivity{

    EditText username, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_launch);

        username = findViewById(R.id.txtIn_Username);
        password = findViewById(R.id.txtIn_Password);
        DB = new DBHelper(this);



        // If login clicked
        Button btnLogin = findViewById(R.id.btn_Login);
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
                    login.putExtra("username", user);
                    startActivity(login);
                } else {
                    Toast.makeText(LoginLaunch.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }

        });

        // If Create Account clicked
        Button btnCreate = findViewById(R.id.btn_CreateAcc);
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

}
