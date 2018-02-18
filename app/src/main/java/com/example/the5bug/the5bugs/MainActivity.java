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
import java.util.ArrayList;
import java.util.List;

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
    ParticleDevice ourDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ourDevice = getIntent().getParcelableExtra("ourDevice");

        connectText = (TextView)findViewById(R.id.textView5);

        connectText.setText(ourDevice.getName());

        final View viewF = findViewById(android.R.id.content);




        armButton = (Button)findViewById(R.id.Armbutton);
        disButton = (Button)findViewById(R.id.disarmButton);


        armButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<String> armList = new ArrayList<String>();
                armList.add("Arm");

                try{
                    ourDevice.callFunction("setMotion", armList);
                }catch(Exception e){
                    e.getMessage();
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                //turnOn(viewF);
                //Toast.makeText(getApplicationContext(), armString, Toast.LENGTH_SHORT).show();
            }
        });

        disButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                List<String> disarmList = new ArrayList<String>();
                disarmList.add("Disarm");

                try{
                    ourDevice.callFunction("setMotion", disarmList);
                }catch(Exception e){
                    e.getMessage();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }

                //turnOff(viewF);
                //Toast.makeText(getApplicationContext(), disarmString, Toast.LENGTH_SHORT).show();
            }
        });


    }

//    private void turnOn(View myView){
//
//        Async.executeAsync(ParticleCloud.get(myView.getContext()), new Async.ApiWork<ParticleCloud, Void>() {
//
//            public Void callApi(ParticleCloud sparkCloud) throws ParticleCloudException, IOException {
//                try{
//                    ourDevice.callFunction("Arm", null);
//                    Toast.makeText(getApplicationContext(), "Armed.", Toast.LENGTH_SHORT).show();
//                }catch(Exception e){
//                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
//                }
//
//                return null;
//            }
//
//            @Override
//            public void onSuccess(Void aVoid) {
//                Toaster.l(MainActivity.this, "System is armed.");
//            }
//
//            @Override
//            public void onFailure(ParticleCloudException e) {
//                //Log.e("LOGIN_FAILURE", e);
//                Toaster.l(MainActivity.this, "ERROR RUNNING CODE.");
//            }
//        });
//    }

//    private void turnOff(View myView){
//
//        Async.executeAsync(ParticleCloud.get(myView.getContext()), new Async.ApiWork<ParticleCloud, Void>() {
//
//            public Void callApi(ParticleCloud sparkCloud) throws ParticleCloudException, IOException {
//                try{
//                    ourDevice.callFunction("Disarm");
//                    Toast.makeText(getApplicationContext(), "Disarmed.", Toast.LENGTH_SHORT).show();
//                }catch(Exception e){
//                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
//            }
//
//                return null;
//            }
//
//            @Override
//            public void onSuccess(Void aVoid) {
//                Toaster.l(MainActivity.this, "System is armed.");
//            }
//
//            @Override
//            public void onFailure(ParticleCloudException e) {
//                //Log.e("LOGIN_FAILURE", e);
//                Toaster.l(MainActivity.this, "ERROR RUNNING CODE.");
//            }
//        });
//    }


}
