package com.ninja.testninja.Interfaces

import android.view.View
import com.ninja.testninja.DataClass.StartLinks

interface StarView {
    fun popularRecyclerView(obj: Any)
    fun performRequest(startLinks: StartLinks)
    fun isRefreshing()
    fun configRefresh(view: View)
}