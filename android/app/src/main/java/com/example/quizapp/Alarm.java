package com.example.quizapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;


/**
 * Sets background alarm for activities
 */
public class Alarm extends BroadcastReceiver {

    /**
     * This is called whenever alarm reaches its
     */
    @Override
    public void onReceive(Context context, Intent intent)
    {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "QuizApp:WakeLock1");
        wl.acquire();

        // Intent
        Intent i = new Intent();
        i.setClass(context, Popup.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Starts activity
        context.startActivity(i);

        wl.release();
    }

    /**
     * Set alarm to run the background activity on screen
     */
    public void setAlarm(Context context)
    {
        AlarmManager am = ( AlarmManager )context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 10, pi); // Millisec * Second * Minute
    }


    /**
     * Cancels previously set alarm
     */
    public void cancelAlarm(Context context)
    {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}

