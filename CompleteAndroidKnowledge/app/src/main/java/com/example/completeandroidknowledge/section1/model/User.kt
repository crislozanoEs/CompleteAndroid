package com.example.completeandroidknowledge.section1.model

import androidx.room.ColumnInfo
import java.util.*

data class User(
    var password: String = "",
    var userDocument: String = "",
    var userType: String = "",
    var userName: String = "",
    var userPassword: String = "",
    var userLastName: String = "",
    var userTypeBank: Int = 0,
    var userCompleteName: String = "",
    var userImageSecure: Int = 0,
    var userLastSessionDateString: String = "",
    var userSessionRefresh: Int = 0,
    var userSessionInactivity: Int = 0
) {
    var userLastSessionDate: Date? = null
    init{
        //userLastSessionDate = Date(userLastSessionDateString)
    }
}

fun User.asDatabaseObject(): UserTable{
    return UserTable(
        document = userDocument,
        type = userType,
        name = userName,
        lastName = userLastName,
        dateLastSession = userLastSessionDateString,
        typeBank = userTypeBank,
        imageSecure = userImageSecure,
        rt = userSessionRefresh,
        st = userSessionInactivity,
        password  = userPassword
    )
}