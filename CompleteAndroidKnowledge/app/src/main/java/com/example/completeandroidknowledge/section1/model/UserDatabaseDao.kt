package com.example.completeandroidknowledge.section1.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDatabaseDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM user_table WHERE document = :document")
    fun get(document: String) : LiveData<User>

    @Query("DELETE FROM user_table")
    fun clearUser()


}