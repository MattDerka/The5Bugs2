package com.example.the5bug.the5bugs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button loginBtn;
    EditText usr, psd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr = (EditText) findViewById(R.id.usr);
        psd = (EditText) findViewById(R.id.psd);
        loginBtn = (Button)findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usr.getText().toString().equals("Admin") && psd.getText().toString().equals("password"))
                {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT);
                    Intent myintent = new Intent(Login.this, MainActivity.class);
                    startActivity(myintent);
                }
            }
        });


    }
}
