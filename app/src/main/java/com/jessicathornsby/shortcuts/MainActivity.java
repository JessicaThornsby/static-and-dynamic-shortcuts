package com.jessicathornsby.shortcuts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Collections;
import android.graphics.drawable.Icon;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;

import java.util.Arrays;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

//Define the intent, which in this instance is launching MainActivity//

        Intent dynamicIntent = new Intent(this,MainActivity.class);
        dynamicIntent.setAction(Intent.ACTION_VIEW);

//Create the ShortcutInfo object//

        ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(this, "dynamic_shortcut")

//Define all the shortcut’s characteristics//

                .setShortLabel("MainActivity")
                .setLongLabel("Launch MainActivity")
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(dynamicIntent)
                .build();
        shortcutManager.setDynamicShortcuts(Collections.singletonList(dynamicShortcut));

        findViewById(R.id.changeShortcutLabel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(MainActivity.this, "dynamic_shortcut")
                        .setShortLabel("Label changed")
                        .build();

                shortcutManager.updateShortcuts(Arrays.asList(dynamicShortcut));
            }
        });
    }


}


