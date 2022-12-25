package com.huy.homework3.data;

import android.content.Context;

import androidx.room.Room;

/**
 * Created by DucLe on 21/12/2022.
 */
public class MyDatabase {
    static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context,
                    AppDatabase.class, "user-database").build();
        }
        return sInstance;
    }
}
