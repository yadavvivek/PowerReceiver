package com.hfda.powerreceiver2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final static String ACTION_CUSTOM_RECEIVER = "com.hfda.powerreceiver2.ACTION_CUSTOM_RECEIVER";

    CustomReceiver mCustomReceiver = new CustomReceiver();

    ComponentName mComponentName;
    PackageManager mPackageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mComponentName = new ComponentName(this, CustomReceiver.class);
        mPackageManager = getPackageManager();

        LocalBroadcastManager.getInstance(this).registerReceiver(mCustomReceiver, new IntentFilter(ACTION_CUSTOM_RECEIVER));
    }

    @Override
    public void onStart() {
        super.onStart();

        mPackageManager.setComponentEnabledSetting(
                mComponentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
        );
    }

    @Override
    public void onStop() {
        super.onStop();

        mPackageManager.setComponentEnabledSetting(
                mComponentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mCustomReceiver);
    }

    public void sendCustomReceiver(View view) {

        Intent intent = new Intent(ACTION_CUSTOM_RECEIVER);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}
