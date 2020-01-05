package com.profileapp.utils

import android.app.Application
import javax.inject.Inject


class NetworkHelper @Inject constructor(val context: Application) {

    fun isNetworkConnected() : Boolean = true
}