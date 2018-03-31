package com.hfda.powerreceiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private final static String ACTION_CUSTOM_RECEIVER = "com.hfda.powerreceiver2.ACTION_CUSTOM_RECEIVER";

    @Override
    public void onReceive(Context context, Intent intent) {

        String toastMessage = null;

        String intentAction = intent.getAction();

        switch(intentAction) {

            case Intent.ACTION_POWER_CONNECTED:
                toastMessage = "Vivek's Phone's power connected!";
                break;

            case Intent.ACTION_POWER_DISCONNECTED:
                toastMessage = "Vivek's phone's power disconnected!";
                break;

            case ACTION_CUSTOM_RECEIVER:
                toastMessage = "Vivek you generated Custom Broadcast!";
        }
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
