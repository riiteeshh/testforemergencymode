package com.example.testforproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView check;
    int n=0; // to check no of button press
    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        check=findViewById(R.id.check);
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP){// this will be change to power button for the project

        n++;
        if(n==1){
            // counter for the 5 second timer
            long duration= TimeUnit.SECONDS.toMillis(5); // 5 is 5 second
            new CountDownTimer(duration, 1000) // timer for 5sec
             {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                // process after completing the counter
                public void onFinish() {
                    n=0;
                    check.setText("time over");

                }
            }.start();
        }

        if(n==5){
            check.setText("Emergency mode started"); // process after count for button is 5
            n=0;

        }}


        return super.onKeyDown(keyCode, event);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }
}