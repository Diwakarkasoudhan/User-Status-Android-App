package com.diwakar.nath.userstatusonline_offline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    /* ID and PASSWORD */
    String username = "user";
    String password = "123";

    EditText userName;
    EditText  userPassword;
    Button userLogin;
    ImageView imageView;
    Calendar calendar;

    // user last status
    String Date = "Default";

    // user status
    boolean userStatus = false;

    Intent userIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.editTextTextPersonName);
        userPassword = (EditText) findViewById(R.id.editTextTextPassword);
        userLogin = (Button) findViewById(R.id.button5);
        imageView = (ImageView) findViewById(R.id.imageView3);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
                if(userStatus) {
                    makeIntentConnected();
                }
                else {
                    makeIntentOffline();
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAdminPage();
            }
        });
    }

    public void checkLogin() {
        String enteredUserName = userName.getText().toString();
        String enteredUserPassword = userPassword.getText().toString();

        if(username.equals(enteredUserName)) {
            if(password.equals(enteredUserPassword)) {
                checkConnection();
            }
            else {
                Toast.makeText(getApplicationContext(), "Entered Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Entered Wrong Username", Toast.LENGTH_SHORT).show();
        }
    }


    public void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if(null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                userStatus = true;
                getDateTime();
            }

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                userStatus = true;
                getDateTime();
            }
        }
        else {
            userStatus = false;
        }
    }

    public void getDateTime() {

        // getting date & time

        calendar = Calendar.getInstance();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date = simpledateformat.format(calendar.getTime());
        //dateData.setDate(Date);

        Log.d("admin12345", Date);
    }

    public void makeIntentConnected() {
        userIntent = new Intent(this, userstatus.class);
        startActivity(userIntent);
    }

    public void makeIntentOffline() {
        userIntent = new Intent(this, userstatus_offline.class);
        startActivity(userIntent);
    }

    public void goToAdminPage() {
        Intent intent = new Intent(this, adminlogin.class);
        intent.putExtra("aaa", Date);
        startActivity(intent);
    }
}