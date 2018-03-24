package com.ninja.testninja.Interfaces

import com.ninja.testninja.DataClass.Detail

interface PresentationFragment {
    fun popularFragment(obj: Any)
    fun popularRecyclerView(obj: Any)
    fun implement(obj: Detail)
    fun implementMap(obj: Detail)
    fun moviMap(obj: Detail)
}