package com.dl.roomexample.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by DucLe on 21/12/2022.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
