package com.example.eteam.appwearness;

import android.app.NotificationManager;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseReciever extends FirebaseMessagingService {
    private static final String TAG = "EARL IS REAL";

    @RequiresApi(api = 16)
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("Firebase Test", "Pumasok");
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "onMessageReceived: Data -> " + ((String) remoteMessage.getData().get("type")));
        if (((String) remoteMessage.getData().get("type")) == "disaster") {
            Builder mBuilder = new Builder(this).setSmallIcon(C0361R.drawable.ww3).setContentTitle((CharSequence) remoteMessage.getData().get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)).setContentText((CharSequence) remoteMessage.getData().get("message"));
            Intent resultIntent = new Intent(this, MainActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            mBuilder.setContentIntent(stackBuilder.getPendingIntent(0, 134217728));
            ((NotificationManager) getSystemService("notification")).notify(0, mBuilder.build());
            return;
        }
        mBuilder = new Builder(this).setSmallIcon(C0361R.drawable.cur_10n).setContentTitle((CharSequence) remoteMessage.getData().get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)).setContentText((CharSequence) remoteMessage.getData().get("message"));
        resultIntent = new Intent(this, MainActivity.class);
        stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        mBuilder.setContentIntent(stackBuilder.getPendingIntent(0, 134217728));
        ((NotificationManager) getSystemService("notification")).notify(0, mBuilder.build());
    }
}
