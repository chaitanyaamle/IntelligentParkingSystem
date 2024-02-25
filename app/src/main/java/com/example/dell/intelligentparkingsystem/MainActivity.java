package com.example.dell.intelligentparkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        final Button admin = (Button)findViewById(R.id.button7);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,admin_login.class));
            }
        });

    }


}
