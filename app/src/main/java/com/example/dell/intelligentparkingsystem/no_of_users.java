package com.example.dell.intelligentparkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class no_of_users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_of_users);


        WebView webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("https://console.firebase.google.com/u/1/project/ipslogin-747e7/authentication/users");
    }
}
