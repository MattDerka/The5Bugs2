package com.example.the5bug.the5bugs;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import io.particle.android.sdk.cloud.ParticleCloud;
import io.particle.android.sdk.cloud.ParticleCloudException;
import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.cloud.ParticleDevice;
import io.particle.android.sdk.utils.Async;
import io.particle.android.sdk.utils.Toaster;

public class MainActivity extends AppCompatActivity {

    protected Button armButton;
    protected Button disButton;
    protected TextView connectText;
    String disarmString = "Detector now disarmed";
    String armString = "Detector now armed";
    ParticleDevice d;
    Button b1, b2;
    EditText ed1, ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        connectText = (TextView)findViewById(R.id.textView5);

        View viewF = findViewById(android.R.id.content);
        TEST(viewF, "fa","fda");



        armButton = (Button)findViewById(R.id.Armbutton);
        disButton = (Button)findViewById(R.id.disarmButton);


        armButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), armString, Toast.LENGTH_SHORT).show();
            }
        });

        disButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                Toast.makeText(getApplicationContext(), disarmString, Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * @brief This function attempts to login with the user name and password passed in as arguments
     * @param myView specifies the view from which this is being called
     * @param emailInput specifies the user name to try logging in with
     * @param passInput specifies the password to attempt logging in with
     */
    private void TEST(View myView, final String emailInput, final String passInput){

        Async.executeAsync(ParticleCloud.get(myView.getContext()), new Async.ApiWork<ParticleCloud, Void>() {

            public Void callApi(ParticleCloud sparkCloud) throws ParticleCloudException, IOException {
                d = sparkCloud.getDevice("3b0029000f51353433323633");
                connectText.setText(d.getName());
                return null;
            }

            @Override
            public void onSuccess(Void aVoid) {

                Toaster.l(MainActivity.this, "GHLDFKDSKLFJDSLVKDS in");
                // Switch to new screen to list all connected devices

            }

            @Override
            public void onFailure(ParticleCloudException e) {
                //Log.e("LOGIN_FAILURE", e);
                Toaster.l(MainActivity.this, "Wrong credentials or no internet connectivity, please try again");
            }
        });
    }

}
