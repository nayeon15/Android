package com.example.gramo

import android.provider.ContactsContract
import android.telecom.Call
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CalendarList {
    @GET ("users/current/durations")
    fun getCoding(
        @Query ("Authentication") Auth:String
    )


}