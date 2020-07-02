package com.example.completeandroidknowledge.repository.userDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDatabaseDao {
    @Insert
    fun insert(userTable: UserTable)

    @Update
    fun update(userTable: UserTable)

    @Query("SELECT * FROM user_table")
    fun get() : LiveData<UserTable>

    @Query("DELETE FROM user_table")
    fun clearUser()


}