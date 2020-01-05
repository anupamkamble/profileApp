package com.profileapp.data.remote.response


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DummyResponse(
    @Expose
    @SerializedName("statusCode")
    var statusCode: String,

    @Expose
    @SerializedName("message")
    var message: String

)