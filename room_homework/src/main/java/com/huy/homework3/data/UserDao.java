package com.huy.homework3.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE name LIKE :name AND " +
            "number  LIKE :number LIMIT 1")
    User findByName(String name, String number);

    @Insert
    void insertAll(User... users);

    @Delete
    int delete(User user);

    @Update
    void update(User... users);
}
