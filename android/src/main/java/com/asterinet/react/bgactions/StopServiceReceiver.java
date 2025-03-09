package com.asterinet.react.bgactions;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StopServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent stopIntent = new Intent(context, RNBackgroundActionsTask.class);
        context.stopService(stopIntent); // Dừng service
        // Xóa notification
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.cancel(RNBackgroundActionsTask.SERVICE_NOTIFICATION_ID);
        }
    }
}
