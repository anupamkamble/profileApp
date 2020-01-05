package com.profileapp.di.components

import com.profileapp.di.ViewHolderScope
import com.profileapp.di.modules.BaseViewHolderModule
import com.profileapp.ui.home.HomeItemViewModel
import dagger.Component



@ViewHolderScope
@Component(modules = [BaseViewHolderModule::class])
interface BaseViewHolderComponent {

    fun inject(viewModel: HomeItemViewModel)
}