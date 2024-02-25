package com.example.dell.intelligentparkingsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alogged_in extends AppCompatActivity {

    private Button slt,nou;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alogged_in);

        slt = findViewById(R.id.Slots);
        nou = findViewById(R.id.USers);

        slt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alogged_in.this,parking_slots.class));
                Toast.makeText(Alogged_in.this,"Showing Slots which are Vacant and Booked",Toast.LENGTH_SHORT).show();


            }
        });

        nou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alogged_in.this,no_of_users.class));
                Toast.makeText(Alogged_in.this,"Showing Number of User",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
