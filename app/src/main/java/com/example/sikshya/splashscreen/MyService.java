package com.example.sikshya.splashscreen;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Sikshya on 11/20/2017.
 */

public class MyService extends Service {
    private static final int nID = 101;
    Notification n;
    NotificationHelper notificationHelper;
    NotificationManager nManager;
    MediaPlayer mediaPlayer;
    Notification.Builder builder;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        n = new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("this is title")
                .setContentText("and this is the content text")
                .build();
        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nManager.notify(nID, n);
        createNotification();


        return START_STICKY;
    }

    private void createNotification() {
        notificationHelper = new NotificationHelper(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = notificationHelper.getChannelNotification("hey", "you");
            notificationHelper.getManager().notify(nID, builder.build());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            builder = notificationHelper.getNormalNotification("hey", "you");
            notificationHelper.getManager().notify(nID, builder.build());
        }


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
