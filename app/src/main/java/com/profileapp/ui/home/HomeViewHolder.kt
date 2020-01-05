package com.profileapp.ui.home

import android.view.View
import android.view.ViewGroup
import com.coal.profileapp.R
import com.profileapp.di.components.BaseViewHolderComponent
import com.profileapp.ui.base.BaseItemViewHolder
import com.profileapp.ui.home.homePojo.HomeContent


class HomeViewHolder(parent: ViewGroup) : BaseItemViewHolder<HomeContent,HomeItemViewModel>(R.layout.item_view,parent){
    override fun injectDependencies(viewHolderComponent: BaseViewHolderComponent) {

    }

    override fun setupView(view: View) {
    }


}