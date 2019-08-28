package com.example.room;


import androidx.room.Insert;

@androidx.room.Dao

public interface Dao {

   //Database Insertion Method
    @Insert
    public void addUser(User user);


}
