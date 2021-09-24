package com.example.a19soece11036;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fuel extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    EditText e6;
    EditText e7;
    Button submit;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);

            Toast.makeText(getApplicationContext(),"FuelRefill",Toast.LENGTH_LONG).show();
            e1 = (EditText) findViewById(R.id.etdate);
            e2 = (EditText) findViewById(R.id.ettime);
            e3 = (EditText) findViewById(R.id.etodo);
            e4 = (EditText) findViewById(R.id.etlodo);
            e5 = (EditText) findViewById(R.id.etprice);
            e6 = (EditText) findViewById(R.id.etfu);
            e7 = (EditText) findViewById(R.id.etcost);
        Button submit = (Button) findViewById(R.id.submit);
        databaseHelper = new DatabaseHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FuelIntent = new Intent(fuel.this,FuelRecord.class);
                startActivity(FuelIntent);
            }
        });
        }

        public void Average(View v)
        {
            double a;
            if(e3.length()>0 && e5.length()>0 && e6.length()>0)
            {
                double km=Double.parseDouble(e3.getText().toString());
                double sr=Double.parseDouble(e5.getText().toString());
                double pr=Double.parseDouble(e6.getText().toString());
                a=sr*(km/100)*pr;
                a=Math.round(a*100.00)/100.00;
                e7.setText((int) a);
            }
            else Toast.makeText(getApplicationContext(),"Enter valid detail",Toast.LENGTH_LONG).show();
        }
    }