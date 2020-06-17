package com.example.completeandroidknowledge.section1.network

import com.example.completeandroidknowledge.commons.getLastNameFromComplete
import com.example.completeandroidknowledge.commons.getNameFromComplete
import com.example.completeandroidknowledge.section1.model.User
import com.example.completeandroidknowledge.section1.model.UserTable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import okhttp3.internal.Util

@JsonClass(generateAdapter = true)
data class UserNetwork(
    @Json(name = "complete_user_name")
    val userCompleteName: String = "",
    @Json(name="user_type")
    val userTypeBank: Int = 0,
    @Json(name="imagen_relation_secure")
    val imageIdSecure: Int = 0,
    @Json(name="session_refresh")
    val sessionRefreshTime: Int = 0,
    @Json(name="session_inactivity")
    val sessionInactivityTime: Int = 0,
    @Json(name="last_session")
    val lastSessionDate: String = "")


fun UserNetwork.asDomainObject(): User {
    return User(
        userLastSessionDateString = lastSessionDate,
        userImageSecure = imageIdSecure,
        userTypeBank = userTypeBank,
        userSessionInactivity = sessionInactivityTime,
        userSessionRefresh = sessionRefreshTime,
        userCompleteName = userCompleteName
    )
}

fun UserNetwork.asDatabaseObject(): UserTable {
    return UserTable(
        rt = sessionRefreshTime,
        st = sessionInactivityTime,
        imageSecure = imageIdSecure,
        typeBank =  userTypeBank,
        dateLastSession = lastSessionDate,
        name = getNameFromComplete(userCompleteName),
        lastName = getLastNameFromComplete(userCompleteName)
    )
}