package com.example.dell.intelligentparkingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Register1 extends AppCompatActivity {

    private EditText Name, userName, userPassw, userEmail, userPhno;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_contact = userPhno.getText().toString().trim();
                String user_name = userName.getText().toString().trim();
                String name = Name.getText().toString().trim();
                String user_email = userEmail.getText().toString().trim();
                String user_passw = userPassw.getText().toString().trim();

                Map<String,String> userMap = new HashMap<>();
                userMap.put("Name",name);
                userMap.put("Username",user_name);
                userMap.put("Email id",user_email);
                userMap.put("Password",user_passw);
                userMap.put("Contact",user_contact);

                firebaseFirestore.collection("Users").add(userMap);


                if(validate1())
                {
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Register1.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register1.this,user_login.class));
                            }
                            else{
                                Toast.makeText(Register1.this,"Registration Failed!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register1.this, user_login.class));
            }
        });

    }

    private void setupUIViews() {
        Name = (EditText) findViewById(R.id.Name);
        userName = (EditText) findViewById(R.id.alUsername);
        userPassw = (EditText) findViewById(R.id.Pswd);
        userEmail = (EditText) findViewById(R.id.E_mail);
        userPhno = (EditText) findViewById(R.id.Ph_No);
        regButton = (Button) findViewById(R.id.Register1);
        userLogin = (TextView) findViewById(R.id.ULogin);
    }

    private Boolean validate1()
    {
        Boolean result = false;

        String name = Name.getText().toString();
        String username = userName.getText().toString();
        String password = userPassw.getText().toString();
        String email = userEmail.getText().toString();
        String contact = userPhno.getText().toString();

        if(name.isEmpty() && username.isEmpty() && password.isEmpty() && email.isEmpty() && contact.isEmpty())
        {
            Toast.makeText(this, "Please Enter all Details.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;
        }

        return result;
    }
}
