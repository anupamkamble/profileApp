package com.profileapp.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.profileapp.di.components.BaseViewHolderComponent
import com.profileapp.di.components.DaggerBaseViewHolderComponent
import com.profileapp.di.modules.BaseViewHolderModule
import javax.inject.Inject

abstract class BaseItemViewHolder<T:Any, VM:BaseItemViewModel<T>>(
    @LayoutRes
    resId:Int, parent: ViewGroup):
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(resId,parent,false)),
    LifecycleOwner{


    init{
        onCreate()
    }


    open fun   bind(data : T){

        viewModel.updateData(data)
    }


    @Inject
    lateinit var lifecycleRegistry: LifecycleRegistry

    @Inject
    lateinit var  viewModel: VM


    override fun getLifecycle(): Lifecycle  = lifecycleRegistry


    fun  onCreate(){

        injectDependencies(buildComponent())
        lifecycleRegistry.setCurrentState(Lifecycle.State.INITIALIZED)
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED)
        setupObservers()
        setupView(itemView)
    }



    fun onStart() {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    fun onStop() {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    fun onDestroy() {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }



    fun buildComponent() = DaggerBaseViewHolderComponent
        .builder()
        .baseViewHolderModule(BaseViewHolderModule(this))
        .build()



    fun showMessage(message: String) = Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(itemView.context.getString(resId))

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })
    }

    protected abstract fun injectDependencies(viewHolderComponent: BaseViewHolderComponent)

    abstract fun setupView(view: View)

}