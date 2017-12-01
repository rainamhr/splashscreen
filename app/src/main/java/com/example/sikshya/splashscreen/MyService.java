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
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Sikshya on 11/20/2017.
 */

public class MyService extends Service {
    private static final int nID = 101;
    NotificationHelper notificationHelper;
    MediaPlayer mediaPlayer;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationHelper = new NotificationHelper(getApplicationContext());
            }
        } catch (Exception e) {
            Log.e("error myan", e.getMessage());
        }
        NotificationCompat.Builder builder = notificationHelper.getAndroidChannelNotification("hello", "dear");
        notificationHelper.getManager().notify(nID, builder.build());


        return START_STICKY;
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
