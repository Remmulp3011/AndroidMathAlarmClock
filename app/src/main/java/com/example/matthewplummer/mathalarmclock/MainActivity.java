package com.example.matthewplummer.mathalarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    PendingIntent pending_intent;

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
        final Calendar calendar = Calendar.getInstance();

        //Create an intent to the alarm receiver class
        final Intent my_intent = new Intent(this.context,Alarm_Receiver.class);

        //Inialize the on button
        Button alarm_on = (Button) findViewById(R.id.alarm_on);

        //Create an on click listener to start the alarm
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting calander with the hour and minute that we picked on the time picker
                calendar.set(Calendar.HOUR_OF_DAY, alarm_time_picker.getHour());
                calendar.set(Calendar.MINUTE, alarm_time_picker.getMinute());

                //get the string value of the hour and minute
                int hour = alarm_time_picker.getHour();
                int minute = alarm_time_picker.getMinute();

                //convert the int value to string
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                //Convert 24 hour time to 12 hour time
                if(hour > 12)
                {
                    hour_string = String.valueOf(hour - 12);
                }

                if(minute < 10)
                {
                    //10:7 ----> 10:07
                    minute_string = "0" + String.valueOf(minute);
                }

                //change the update text textBox
                set_alarm_text("Alarm set to: " + hour_string + ":" + minute_string);

                //create a pending intent that delays the intent until the specified calender time
                pending_intent = PendingIntent.getBroadcast(MainActivity.this,0,my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                //set the alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending_intent);
            }
        });

        //Initialze the off button
        Button alarm_off = (Button) findViewById(R.id.alarm_off);
        //Create on click listener to stop the alarm.
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change the update text textBox
                set_alarm_text("Alarm Off");

                alarm_manager.cancel(pending_intent);
            }
        });


    }

    private void set_alarm_text(String output) {
        update_text.setText(output);
    }
}
