package com.example.completeandroidknowledge.repository.userDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.completeandroidknowledge.publicSection.model.User

@Entity(tableName = "user_table")
data class UserTable (
    @PrimaryKey(autoGenerate = false)
    var document: String = "",
    @ColumnInfo(name = "user_type")
    var type: String = "",
    @ColumnInfo(name = "user_name")
    var name: String = "",
    @ColumnInfo(name = "user_last_name")
    var lastName: String = "",
    @ColumnInfo(name = "user_last_session")
    var dateLastSession: String = "",
    @ColumnInfo(name = "user_type_bank")
    var typeBank: Int = 0,
    @ColumnInfo(name = "user_image_secure")
    var imageSecure: Int = 0,
    @ColumnInfo(name = "user_rt")
    var rt: Int = 0,
    @ColumnInfo(name = "user_st")
    var st: Int = 0,
    var password: String = ""
)

fun UserTable.asDomainObject(): User{
    return User(
        userDocument = document,
        userType = type,
        userName = name,
        userLastName = lastName,
        userLastSessionDateString = dateLastSession,
        userImageSecure = imageSecure,
        userTypeBank = typeBank,
        userSessionInactivity = st,
        userSessionRefresh = rt,
        userCompleteName = name + lastName
    )
}