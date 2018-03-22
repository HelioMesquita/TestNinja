package com.ninja.testninja.Interfaces

import com.ninja.testninja.Others.PageNext

interface PresentationFragment {
    fun popularFragment(obj: Any)
    fun popularRecyclerView(obj: Any)
    fun implement(obj: PageNext)
    fun implementMap(obj: PageNext)
    fun moviMap(obj: PageNext)
}