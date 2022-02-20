package com.example.hydrationreminder.sync;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class WaterReminderIntentService extends IntentService {

    public WaterReminderIntentService() {
        super("WaterReminderIntentService");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        ReminderTasks.executeTask(this, action);
    }
}
