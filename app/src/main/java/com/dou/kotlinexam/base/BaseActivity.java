package com.dou.kotlinexam.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by nnbinh on 11/24/17.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String APP_DATA = "APP_DATA";
    public void showMessageByToast(String message) {
        if (message != null && !message.isEmpty()) {
            Toast.makeText(this, message, LENGTH_SHORT).show();
        }
    }

    public void saveDataBySharePref(String key, String value) {
        SharedPreferences preferences = getSharedPreferences(APP_DATA, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getDataBySharePref(String key) {
        SharedPreferences preferences = getSharedPreferences(APP_DATA, Context.MODE_PRIVATE);
        return preferences.getString(key,"");
    }
}
