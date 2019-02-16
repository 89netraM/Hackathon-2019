package com.winnerisolle.apa.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class AlarmHandler {
    private final AlarmManager alarmManager;
    private final PendingIntent pendingIntent;

    public AlarmHandler(Context context) {
        alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, RingerService.class);
        pendingIntent = PendingIntent.getService(context, 0, intent, 0);
    }

    public void getActiveAlarms() {

    }

    public void setAlarmNow() {
        setAlarmIn(0);
    }
    public void setAlarmIn(long millis) {
        setAlarm(SystemClock.elapsedRealtime() + millis);
    }
    private void setAlarm(long millis) {
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, millis, pendingIntent);
    }
}