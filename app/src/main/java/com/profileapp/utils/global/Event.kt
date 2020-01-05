package com.profileapp.utils.global

import java.util.concurrent.atomic.AtomicBoolean


data class Event<out T>(private  val content: T ){

    private val hasBeenUsed = AtomicBoolean(true)

    fun getIfNotHandled():T? = if (hasBeenUsed.getAndSet(true)) null else content

    fun peek(): T = content
}