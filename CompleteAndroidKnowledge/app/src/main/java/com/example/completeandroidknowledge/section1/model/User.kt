package com.example.completeandroidknowledge.section1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = false)
    var document: String = "",
    @ColumnInfo(name = "user_type")
    var type: String = "",
    @ColumnInfo(name = "user_name")
    var name: String = "",
    @ColumnInfo(name = "user_last_name")
    var lastName: String = "",
    //@ColumnInfo(name = "user_last_session")
    //var dateLastSession: Date ?= null,
    var password: String = ""
)