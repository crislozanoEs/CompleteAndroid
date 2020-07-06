package com.example.completeandroidknowledge.sectionTransactional.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Product::class], version = 2, exportSchema = true)
abstract class ProductSummaryDatabase: RoomDatabase() {
    abstract val productSummaryDatabaseDao: ProductSummaryDatabaseDao
    companion object{
        @Volatile
        private var INSTANCE: ProductSummaryDatabase ?= null
        fun getInstance(context: Context): ProductSummaryDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext, ProductSummaryDatabase::class.java, "product_summary_database")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}