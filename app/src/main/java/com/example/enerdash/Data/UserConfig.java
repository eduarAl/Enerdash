package com.example.enerdash.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.enerdash.BuildConfig;
import com.example.enerdash.Modelos.UserModel;

import java.util.Locale;


public class UserConfig {
    private static final String USER_PREF_NAME = "user_prefs";
    private static final String PREF_FIRST_TIME = "is_first_time";
    private static final String PREF_USER_EMAIL = "user_email";
    private static final String PREF_USER_PASSWORD = "user_pw";

    private final SharedPreferences mPrefs;

    public UserConfig(@NonNull Context context) {
        mPrefs = context.getSharedPreferences(getPrefsName(), Context.MODE_PRIVATE);
    }

    public boolean isFirstTime() {
        return mPrefs.getBoolean(PREF_FIRST_TIME, true);
    }

    public boolean setIsFirstTime(Boolean value) {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putBoolean(PREF_FIRST_TIME, value);
        /*
        apply() changes the in-memory SharedPreferences object immediately but writes the updates to disk asynchronously.
        Alternatively, you can use commit() to write the data to disk synchronously. But because commit() is synchronous,
        you should avoid calling it from your main thread because it could pause your UI rendering.
        */
        prefsEditor.apply();
        return true;
    }

    public boolean userExists() {
        return mPrefs.contains(PREF_USER_EMAIL) && mPrefs.contains(PREF_USER_PASSWORD);
    }

    @Nullable
    public UserModel getUser() {
        final String email = mPrefs.getString(PREF_USER_EMAIL, null);
        final String pw = mPrefs.getString(PREF_USER_PASSWORD, null);
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pw)) {
            return null;
        }
        return new UserModel(email, pw);
    }

    public boolean setUser(@Nullable UserModel user) {
        if(user == null) return false;
        if(TextUtils.isEmpty(user.getEmail()) || TextUtils.isEmpty(user.getPassword()))
            return false;

        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString(PREF_USER_EMAIL, user.getEmail());
        prefsEditor.putString(PREF_USER_PASSWORD, user.getPassword());
        prefsEditor.apply();
        return true;
    }

    //When naming your shared preference files, you should use a name that's uniquely identifiable to your app
    private String getPrefsName() {
        return String.format(
                Locale.getDefault(),
                "%s_%s",
                BuildConfig.APPLICATION_ID , USER_PREF_NAME
        );
    }
}
