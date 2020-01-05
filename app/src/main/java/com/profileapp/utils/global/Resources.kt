package com.profileapp.utils.global

data class Resources<out T> private constructor(val status: Status, val data: T?){

    companion object{

        fun <T> success(data: T? = null ): Resources<T> = Resources(Status.SUCCESS, data)

        fun <T> error(data: T? = null ): Resources<T> = Resources(Status.ERROR, data)

        fun <T>loading(data: T? = null ): Resources<T> = Resources(Status.LOADING, data)

        fun <T> unknown(data: T? = null ): Resources<T> = Resources(Status.UNKNOWN, data)

    }

}