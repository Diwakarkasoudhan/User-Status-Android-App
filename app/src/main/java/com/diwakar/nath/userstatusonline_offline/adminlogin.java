package com.diwakar.nath.userstatusonline_offline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    /* ID and PASSWORD */
    String username = "admin";
    String password = "123";

    EditText adminUser;
    EditText adminPassword;
    Button adminLogin;

    Intent adminIntent;
    Intent passUserData;

    // user Last Status Date & Time;
    String dateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        adminUser = (EditText) findViewById(R.id.editTextTextPersonName2);
        adminPassword = (EditText) findViewById(R.id.editTextTextPassword2);
        adminLogin = (Button) findViewById(R.id.button);
        passUserData = getIntent();
        dateTime = passUserData.getStringExtra("aaa");

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });
    }

    public void checkLogin() {
        String enteredAdminName = adminUser.getText().toString();
        String enteredAdminPassword = adminPassword.getText().toString();

        if(username.equals(enteredAdminName)) {
            if(password.equals(enteredAdminPassword)) {
                adminIntent = new Intent(this, admin_panel.class);
                adminIntent.putExtra("currentDateTime", dateTime);
                startActivity(adminIntent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Wrong Password Entered", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Wrong Username Entered", Toast.LENGTH_SHORT).show();
        }
    }

}