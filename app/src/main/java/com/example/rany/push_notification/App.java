package com.example.rany.push_notification;

import android.app.Application;
import android.content.Intent;

import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .setNotificationOpenedHandler(notificationOpenedHandler)
                .init();
    }

    private OneSignal.NotificationOpenedHandler notificationOpenedHandler = result->{
        Intent intent=new Intent(App.this,ArticelActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    };
}
