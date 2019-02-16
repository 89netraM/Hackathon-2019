package com.winnerisolle.apa.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class AlarmHandler {
    private final AlarmManager alarmManager;
    private final Context context;

    public AlarmHandler(Context context) {
        this.context = context;
        alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    }

    public long getNextAlarm() {
        AlarmManager.AlarmClockInfo info = alarmManager.getNextAlarmClock();
        return info != null ? info.getTriggerTime() : -1;
    }

    public void setAlarmNow() {
        setAlarmIn(0);
    }
    public void setAlarmIn(long millis) {
        setAlarm(SystemClock.elapsedRealtime() + millis);
    }
    private void setAlarm(long millis) {
        Intent intent = new Intent(context, RingerService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 1337, intent, PendingIntent.FLAG_ONE_SHOT);

        alarmManager.set(AlarmManager.ELAPSED_REALTIME, millis, pendingIntent);
    }
}