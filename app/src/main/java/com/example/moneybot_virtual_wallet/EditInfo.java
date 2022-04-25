package com.example.moneybot_virtual_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EditInfo extends AppCompatActivity implements View.OnClickListener {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_edit);

        // Contains username info passed from last activity
        extras = getIntent().getExtras();


        Button btnCancel = findViewById(R.id.btn_Cancel);
        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

        //TODO: Insert update info DB code
        Button btnUpdate = findViewById(R.id.btn_Update);
        btnUpdate.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainSettings.class);
            if (extras != null)
                intent.putExtras(extras);
            startActivity(intent);
        });

    }

    // Unused
    public void onClick(View view) {

    }
}
