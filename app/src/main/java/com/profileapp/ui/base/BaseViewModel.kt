package com.profileapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.profileapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    var compositeDisposable: CompositeDisposable,
    var netWorkHelper: NetworkHelper) : ViewModel() {


    val messageStringId = MutableLiveData<Int>()
    val messageString = MutableLiveData<String>()



    protected  fun checkInterNetConnection(): Boolean = netWorkHelper.isNetworkConnected()


    protected  fun handleNetWorkError(err : Throwable){

    }

    abstract fun onCreate()


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}