package com.example.sikshya.splashscreen;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sikshya on 11/20/2017.
 */

public class MyBoundService extends Service {
    private final IBinder binder = new LocalBinder();
    public class LocalBinder extends Binder {
        MyBoundService getService(){
            return MyBoundService.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }



    public Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}
