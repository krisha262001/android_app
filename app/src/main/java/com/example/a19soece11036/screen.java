package com.example.a19soece11036;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Intent a1 = new Intent(screen.this,MainActivity.class);
            startActivity(a1);
            finish();
        }
    };
    Timer timer = new Timer();
        timer.schedule(timerTask,2000);

}
}
