package com.example.dell.intelligentparkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button user = (Button)findViewById(R.id.user);

        user.setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                            Intent newInt = new Intent(v.getContext(),user_login.class);
                            startActivity(newInt);
                        }

                }
        );

        Button admin = (Button)findViewById(R.id.user);

        user.setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        Intent newInt = new Intent(v.getContext(),admin_login.class);
                        startActivity(newInt);
                    }

                }
        );

    }
}
