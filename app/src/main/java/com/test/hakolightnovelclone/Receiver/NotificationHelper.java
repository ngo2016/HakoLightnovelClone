package com.test.hakolightnovelclone.Receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.test.hakolightnovelclone.R;

class NotificationHelper extends ContextWrapper {
    public static final String CHANEL_ID = "Lightnovel reader";
    public static final String CHANEL_NAME = "Hako lightnovel clone";

    NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CreateChanel();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void CreateChanel() {
        NotificationChannel channel = new NotificationChannel(
                CHANEL_ID,
                CHANEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
        );

        channel.setDescription("Đọc lightnovel thôi!!!");
        channel.enableLights(false);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
    }

    public NotificationManager getManager(){
        if (manager==null){
            manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getNotification(String title,
                                                String message,
                                                Uri sound,
                                                PendingIntent pendingIntent,
                                                boolean isClicked){
        return new Notification.Builder(getApplicationContext(), CHANEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_laucher)
                .setSound(sound)
                .setContentIntent(pendingIntent)
                .setAutoCancel(isClicked);
    }
}
