package com.profileapp.data.remote.network

import com.profileapp.data.remote.request.DummyRequest
import com.profileapp.data.remote.request.LoginRequest
import com.profileapp.data.remote.response.DummyResponse
import com.profileapp.data.remote.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface NetworkServices {


    @POST(EndPoints.DUMMY_CALL)
    fun getData(
        @Body dummyRequest: DummyRequest,
        @Header(NetworkClass.HEADER_API_KEY) apiKey: String = NetworkClass.API_KEY
    ) : Single<DummyResponse>


    @POST(EndPoints.LOGIN)
    fun doLogin(
        @Body loginRequest: LoginRequest,
        @Header(NetworkClass.HEADER_API_KEY) apiKey: String= NetworkClass.API_KEY
    ): Single<LoginResponse>
}