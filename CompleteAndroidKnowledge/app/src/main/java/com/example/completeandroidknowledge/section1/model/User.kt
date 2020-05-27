package com.example.completeandroidknowledge.section1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = false)
    var document: String = "",
    @ColumnInfo(name = "user_type")
    var type: String = "",
    var password: String = ""
){

}