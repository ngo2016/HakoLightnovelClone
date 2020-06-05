package com.test.hakolightnovelclone.Receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.test.hakolightnovelclone.MainActivity;
import com.test.hakolightnovelclone.R;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            SendNotificationAPI26(context);
        } else {
            SendNotification(context);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void SendNotificationAPI26(Context context) {
        String title = "Đến giờ đọc lightnovel rồi bạn ơi!!!";
        String message = "Mở app lên và đọc lightnovel ngay đi nào!!!";

        NotificationHelper helper;
        Notification.Builder builder;

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        helper = new NotificationHelper(context);

        builder=helper.getNotification(title, message, sound, pendingIntent, true);

        helper.getManager().notify(1, builder.build());
    }

    private void SendNotification(Context context) {
        String title = "Đến giờ đọc lightnovel rồi bạn ơi!!!";
        String message = "Mở app lên và đọc lightnovel ngay đi nào!!!";

        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_laucher)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setSound(sound);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, builder.build());
    }
}
