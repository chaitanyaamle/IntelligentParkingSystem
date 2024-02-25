package com.example.dell.intelligentparkingsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dell.intelligentparkingsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.collection.LLRBNode;

public class Ulogged_In extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button b1,b2,b3,b4,b5;
    private DatabaseReference ref1,ref2,ref3,ref4,ref5;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulogged__in);

        firebaseAuth = FirebaseAuth.getInstance();
        b1 = findViewById(R.id.st1);
        b2 = findViewById(R.id.st2);
        b3 = findViewById(R.id.st3);
        b4 = findViewById(R.id.st4);
        b5 = findViewById(R.id.st5);

        ref1 = FirebaseDatabase.getInstance().getReference().child("1st Sensor");
        //*********************** FIRST SENSOR *****************************************
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String isensor = (String) dataSnapshot.getValue().toString();
                switch (isensor)
                {
                    case "0":
                        b1.setBackgroundColor(Color.GREEN);
                        b1.setText("VACANT..");
                        break;
                    case "1":
                        b1.setBackgroundColor(Color.RED);
                        b1.setText("BOOKED!!");
                        break;
                }
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //******************************* END *******************************************

        ref2 = FirebaseDatabase.getInstance().getReference().child("2nd Sensor");
        //*********************** SECOND SENSOR *****************************************
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String iisensor = (String) dataSnapshot.getValue().toString();
                switch (iisensor)
                {
                    case "0":
                        b2.setBackgroundColor(Color.GREEN);
                        b2.setText("VACANT..");
                        break;
                    case "1":
                        b2.setBackgroundColor(Color.RED);
                        b2.setText("BOOKED!!");
                        break;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //******************************* END *******************************************

        ref3 = FirebaseDatabase.getInstance().getReference().child("3rd Sensor");
        //*********************** THIRD SENSOR *****************************************
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String iiisensor = (String) dataSnapshot.getValue().toString();
                switch (iiisensor)
                {
                    case "0":
                        b3.setBackgroundColor(Color.GREEN);
                        b3.setText("VACANT..");
                        break;
                    case "1":
                        b3.setBackgroundColor(Color.RED);
                        b3.setText("BOOKED!!");
                        break;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //******************************* END *******************************************

        ref4 = FirebaseDatabase.getInstance().getReference().child("4th Sensor");
        //*********************** FOURTH SENSOR *****************************************
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String ivsensor = (String) dataSnapshot.getValue().toString();
                switch (ivsensor)
                {
                    case "0":
                        b4.setBackgroundColor(Color.GREEN);
                        b4.setText("VACANT..");
                        break;
                    case "1":
                        b4.setBackgroundColor(Color.RED);
                        b4.setText("BOOKED!!");
                        break;
                }
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (ivsensor)
                        {
                            case "0":
                                b4.setBackgroundColor(Color.GRAY);
                                b4.setText("RESERVED");
                                ref4.setValue(0);
                                break;
                            case "1":
                                b4.setBackgroundColor(Color.RED);
                                break;

                        }
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //******************************* END *******************************************

        ref5 = FirebaseDatabase.getInstance().getReference().child("5th Sensor");
        //*********************** FIFTH SENSOR *****************************************
        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String vsensor = (String) dataSnapshot.getValue().toString();
                switch (vsensor)
                {
                    case "0":
                        b5.setBackgroundColor(Color.GREEN);
                        b5.setText("VACANT..");
                        break;
                    case "1":
                        b5.setBackgroundColor(Color.RED);
                        b5.setText("BOOKED!!");
                        break;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //******************************* END *******************************************

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.LogoutMenu:{
                logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Ulogged_In.this, user_login.class));
    }
}
