package com.example.the5bug.the5bugs;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected Button armButton;
    protected Button disButton;
    String disarmString = "Detector now disarmed";
    String armString = "Detector now armed";

    Button b1, b2;
    EditText ed1, ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
}
