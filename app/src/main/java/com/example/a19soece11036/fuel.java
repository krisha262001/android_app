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
    EditText e8;
    Button submit;
    private String newEntry;
    private String message;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);

        Toast.makeText(getApplicationContext(), "FuelRefill", Toast.LENGTH_LONG).show();
        e1 = (EditText) findViewById(R.id.etdate);
        e2 = (EditText) findViewById(R.id.ettime);
        e3 = (EditText) findViewById(R.id.etodo);
        e4 = (EditText) findViewById(R.id.etlodo);
        e5 = (EditText) findViewById(R.id.etprice);
        e6 = (EditText) findViewById(R.id.etfu);
        e7 = (EditText) findViewById(R.id.etcost);
        e8 = (EditText) findViewById(R.id.etavg);
        Button submit = (Button) findViewById(R.id.submit);
        databaseHelper = new DatabaseHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newEntry = e2.getText().toString();
                newEntry = e3.getText().toString();
                newEntry = e4.getText().toString();
                newEntry = e5.getText().toString();
                newEntry = e6.getText().toString();
                newEntry = e7.getText().toString();
                newEntry = e8.getText().toString();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent FuelIntent = new Intent(fuel.this, FuelRecord.class);
                startActivity(FuelIntent);
            }
        });
    }

    public void AddData(int newEntry) {
        boolean insertData = databaseHelper.addData(newEntry);
        if (insertData) {
            toastMessage("Data Successfully Inserted");
        } else {
            toastMessage("Enter valid detail");
        }
    }

        public void Average (View view)
        {
            double a;
            if (e5.length() > 0 && e6.length() > 0 && e7.length() > 0) {
                double km = Double.parseDouble(e5.getText().toString());
                double sr = Double.parseDouble(e6.getText().toString());
                double pr = Double.parseDouble(e7.getText().toString());
                a = (sr * (km / 100) * pr) / 10;
                a = Math.round(a * 100.00) / 100.00;
                e8.setText((int) a);
            } else
                Toast.makeText(getApplicationContext(), "Enter valid detail", Toast.LENGTH_LONG).show();
        }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}