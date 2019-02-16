package com.winnerisolle.apa.Alarm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.winnerisolle.apa.MainActivity;
import com.winnerisolle.apa.R;

public class RingerService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        //We don't need this
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            showNotification();

            RingtonePlayer.play(this);
        }

        return START_STICKY;
    }

    private void showNotification() {
        NotificationManager manager = getSystemService(NotificationManager.class);

        //TODO: Change to alarm response page
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Time for an update")
                .setContentText("Update us on how your studying is going")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("alarms1337", "Alarms", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
            nBuilder.setChannelId(channel.getId());
        }

        manager.notify(1337, nBuilder.build());
    }
}
