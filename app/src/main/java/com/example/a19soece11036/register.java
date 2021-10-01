package com.example.a19soece11036;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class register extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    RadioButton RB1;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText et1 = (EditText) findViewById(R.id.etuname);
        EditText et2 = (EditText) findViewById(R.id.etemail);
        EditText et3 = (EditText) findViewById(R.id.etpass);
        //EditText et4 = (EditText) findViewById(R.id.etaregister);
        RadioButton RB1 = (RadioButton) findViewById(R.id.rbfemale);
        String tv = "";
        if (RB1.isChecked()) {
            tv += "Female\n";
        } else {
            tv += "Male\n";
        }
        Button register = (Button) findViewById(R.id.etregister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(register.this,MainActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}