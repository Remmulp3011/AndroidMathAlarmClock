package com.example.matthewplummer.mathalarmclock;

import android.app.AlarmManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //to make are alarm manager
    AlarmManager alarm_manager;
    TimePicker alarm_time_picker;
    TextView update_text;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;

        //initialze alarm manger
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //intialize time picker
        alarm_time_picker = (TimePicker) findViewById(R.id.timePicker);

        //initalize text update box
        update_text = (TextView) findViewById(R.id.update_text);

        //set up instance of a calender
        Calendar calendar = Calendar.getInstance();

        //Inialize the on button
        Button alarm_on = (Button) findViewById(R.id.alarm_on);
        //Create an on click listener to start the alarm

        //Initialze the off button
        Button alarm_off = (Button) findViewById(R.id.alarm_off);
        //Create on click listener to stop the alarm.



    }
}
