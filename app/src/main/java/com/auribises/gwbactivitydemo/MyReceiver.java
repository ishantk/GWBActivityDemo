package com.auribises.gwbactivitydemo;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;

        String action = intent.getAction();
        if(action.equals("a.b.c.d")){
            showNotification();
        }

        if(action.equals("android.intent.action.BATTERY_LOW")){

        }

    }

    void showNotification(){
        //NotificationManager notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        //...

        Toast.makeText(context,"Notification Received",Toast.LENGTH_LONG).show();
    }
}
