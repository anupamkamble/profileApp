package com.profileapp.ui.base

import androidx.lifecycle.MutableLiveData
import com.profileapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable


abstract class BaseItemViewModel<T:Any>(var composite: CompositeDisposable,
                                        var networkHelper: NetworkHelper)
    : BaseViewModel(composite,networkHelper) {




    val data: MutableLiveData<T> = MutableLiveData()

    fun manualCleared() = onCleared()

    fun updateData(data :T ){
        this.data.postValue(data)
    }

}