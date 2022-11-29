package com.example.foodapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private Context context;
    private String PREFName = "SharedPreferences";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public PreferencesHelper(Context context) {
        this.context = context;
       this.sharedPreferences = context.getSharedPreferences(PREFName,Context.MODE_PRIVATE);
       this. editor = sharedPreferences.edit();
    }

    public void putString(String key, String value) {
        editor.putString(key, value).apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value).apply();
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void clearAll() {
        editor.clear().apply();
    }
}
