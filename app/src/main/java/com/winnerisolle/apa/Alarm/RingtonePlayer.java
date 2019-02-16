package com.winnerisolle.apa.Alarm;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

public class RingtonePlayer {
    private static final Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
    private static Ringtone ringtone;

    public static void play(Context context) {
        ringtone = RingtoneManager.getRingtone(context, alarm);
        ringtone.play();
    }
    public static void stop() {
        if (ringtone != null && ringtone.isPlaying())
        ringtone.stop();
    }
}
