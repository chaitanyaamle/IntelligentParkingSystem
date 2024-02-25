package com.example.dell.intelligentparkingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class admin_login extends AppCompatActivity {

    private EditText uname;
    private EditText pass;
    private Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        uname = (EditText) findViewById(R.id.alUsername);
        pass = (EditText)findViewById(R.id.alpassword);
        log = (Button)findViewById(R.id.alogin);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().equals("Admin") && pass.getText().toString().equals("admin1234"))
                {
                    Toast.makeText(admin_login.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(admin_login.this,Alogged_in.class));
                }
                else
                {
                    Toast.makeText(admin_login.this,"Login Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
