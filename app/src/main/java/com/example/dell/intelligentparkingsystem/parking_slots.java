package com.example.dell.intelligentparkingsystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class parking_slots extends AppCompatActivity {
    DatabaseReference ref1,ref2,ref3,ref4,ref5;
    private TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_slots);

        t1 = findViewById(R.id.Slt1);
        t2 = findViewById(R.id.Slt2);
        t3 = findViewById(R.id.Slt3);
        t4 = findViewById(R.id.Slt4);
        t5 = findViewById(R.id.Slt5);

        ref1 = FirebaseDatabase.getInstance().getReference().child("1st Sensor");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String slt1 = dataSnapshot.getValue().toString();
                switch (slt1){
                    case "0":
                        t1.setText("Slot 1 : VACANT..");
                        break;
                    case "1":
                        t1.setText("Slot 1 : BOOKED!!");
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref2 = FirebaseDatabase.getInstance().getReference().child("2nd Sensor");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String slt2 = dataSnapshot.getValue().toString();
                switch (slt2){
                    case "0":
                        t2.setText("Slot 2 : VACANT..");
                        break;
                    case "1":
                        t2.setText("Slot 2 : BOOKED!!");
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref3 = FirebaseDatabase.getInstance().getReference().child("3rd Sensor");
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String slt3 = dataSnapshot.getValue().toString();
                switch (slt3){
                    case "0":
                        t3.setText("Slot 3 : VACANT..");
                        break;
                    case "1":
                        t3.setText("Slot 3 : BOOKED!!");
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref4 = FirebaseDatabase.getInstance().getReference().child("4th Sensor");
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String slt4 = dataSnapshot.getValue().toString();
                switch (slt4){
                    case "0":
                        t4.setText("Slot 4 : VACANT..");
                        break;
                    case "1":
                        t4.setText("Slot 4 : BOOKED!!");
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref5 = FirebaseDatabase.getInstance().getReference().child("5th Sensor");
        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String slt1 = dataSnapshot.getValue().toString();
                switch (slt1){
                    case "0":
                        t5.setText("Slot 5 : VACANT..");
                        break;
                    case "1":
                        t5.setText("Slot 5 : BOOKED!!");
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
