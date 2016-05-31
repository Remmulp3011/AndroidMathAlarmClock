package com.example.matthewplummer.mathalarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by matthewplummer on 31/05/16.
 */
public class Alarm_Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("We are in the Receiver", "YAY!");

    }
}
