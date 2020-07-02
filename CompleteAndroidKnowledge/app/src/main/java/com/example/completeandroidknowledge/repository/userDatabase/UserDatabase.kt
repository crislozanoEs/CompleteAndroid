package com.example.completeandroidknowledge.repository.userDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserTable::class], version = 3, exportSchema = true)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDatabaseDao: UserDatabaseDao
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase?= null
        fun getInstance(context: Context): UserDatabase {
            synchronized(this){
                var instance =
                    INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}