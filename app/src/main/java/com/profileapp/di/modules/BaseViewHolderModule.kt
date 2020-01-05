package com.profileapp.di.modules

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import com.profileapp.di.ViewHolderScope
import com.profileapp.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides


@Module
class BaseViewHolderModule(var viewHolder: BaseItemViewHolder<*, *>) {

    @ViewHolderScope
    @Provides
    fun providesLifecycleRegistry():Lifecycle = LifecycleRegistry(viewHolder)

}