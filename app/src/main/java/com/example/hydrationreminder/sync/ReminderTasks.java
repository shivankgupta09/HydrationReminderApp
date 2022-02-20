package com.example.hydrationreminder.sync;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.hydrationreminder.utilities.NotificationUtils;
import com.example.hydrationreminder.utilities.PreferenceUtilities;

public class ReminderTasks {

    public static final String ACTION_INCREMENT_WATER_COUNT = "increment-water-count";
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";
    static final String ACTION_CHARGING_REMINDER = "charging-reminder";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void executeTask(Context context, String action) {
        if (ACTION_INCREMENT_WATER_COUNT.equals(action)) {
            incrementWaterCount(context);
        } else if (ACTION_DISMISS_NOTIFICATION.equals(action)) {
            NotificationUtils.clearAllNotifications(context);
        } else if (ACTION_CHARGING_REMINDER.equals(action)) {
            issueChargingReminder(context);
        }
    }

    private static void incrementWaterCount(Context context) {
        PreferenceUtilities.incrementWaterCount(context);
        NotificationUtils.clearAllNotifications(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static void issueChargingReminder(Context context) {
        PreferenceUtilities.incrementChargingReminderCount(context);
        NotificationUtils.remindUserBecauseCharging(context);
    }
}
