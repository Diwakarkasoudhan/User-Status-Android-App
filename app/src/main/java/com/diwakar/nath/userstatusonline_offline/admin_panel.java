package com.diwakar.nath.userstatusonline_offline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class admin_panel extends AppCompatActivity {

    TextView userDateTime;
    String dateTime;
    Intent userIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        userIntent = getIntent();
        dateTime = userIntent.getStringExtra("currentDateTime");
        userDateTime = (TextView) findViewById(R.id.textView8);
        userDateTime.setText(dateTime);

    }
}