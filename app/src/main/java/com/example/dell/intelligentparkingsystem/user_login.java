package com.example.dell.intelligentparkingsystem;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class user_login extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        final EditText aUname = (EditText) findViewById(R.id.alUsername);
        final EditText aPassword = (EditText) findViewById(R.id.alpassword);
        final Button aLogin = (Button) findViewById(R.id.alogin);
        final TextView aReHe = (TextView) findViewById(R.id.Registerhere);
        forgotPassword = (TextView)findViewById(R.id.ForPass);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null)
        {
            finish();
            startActivity(new Intent(user_login.this, Ulogged_In.class));
        }

        aLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(aUname.getText().toString(), aPassword.getText().toString());
            }
        });

        aReHe.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        Intent ReHe = new Intent(v.getContext(),Register1.class);
                        startActivity(ReHe);
                    }

                }
        );

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_login.this, PasswordActivity.class));
            }
        });
    }

    private void validate(String userName, String userPassword){

        progressDialog.setMessage("Searching for Space. Car Booking is Available. Park your Car!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Toast.makeText(user_login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(user_login.this,Ulogged_In.class));
                }
                else {
                    Toast.makeText(user_login.this,"Login Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
