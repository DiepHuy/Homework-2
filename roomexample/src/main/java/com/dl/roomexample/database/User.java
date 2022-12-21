package com.dl.roomexample.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by DucLe on 21/12/2022.
 */
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;
}
