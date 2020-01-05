package com.profileapp.ui.home

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.profileapp.ui.base.BaseAdapter
import com.profileapp.ui.home.homePojo.HomeContent


class HomeAdapter(parentLifecycle: Lifecycle
                  ,data:ArrayList<HomeContent>) : BaseAdapter<HomeContent,HomeViewHolder>(parentLifecycle,data){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder(parent)

}