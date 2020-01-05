package com.profileapp.data.remote.network

import com.profileapp.data.model.User
import com.profileapp.data.remote.request.LoginRequest
import io.reactivex.Single
import javax.inject.Inject


class UserRepo @Inject constructor(
    private val networkService: NetworkServices
) {


    fun doLogin(email: String, password: String):Single<User> =

        networkService.doLogin(LoginRequest(email,password))
            .map {

                User(it.userId,
                    it.userName,
                    it.userEmail,
                    it.accessToken,
                    it.profilePicUrl
            )

        }

    }