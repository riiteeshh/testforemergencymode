package com.example.testforproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView check;
    int n=0;// to check no of button press
    String p ="9865762048";
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
            // checking the permission for the calling system
            if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                callPhone();} // calling function
                else
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},101);


            n=0;



        }}


        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==101 && grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){ // checking if the permission is granted
            callPhone();
        }
        else
            Toast.makeText(this, "Please accept all the permissions", Toast.LENGTH_SHORT).show();
    }

    private void callPhone() { // function to call
        Intent intent= new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: "+ p));
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}