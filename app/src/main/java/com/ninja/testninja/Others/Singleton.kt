package com.ninja.testninja.Others

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.ninja.testninja.Activitys.MainActivity

object Singleton {
    lateinit var mainLinks: startLinks
    lateinit var offers: CreatOffers
    lateinit var offersNext: Offers
    lateinit var leads: CreatLeads

    lateinit var recylerViewLeads: RecyclerView

    lateinit var context: Context

    lateinit var mainActivity: MainActivity

    fun requistLeadsParameters(recylerViewLeads: RecyclerView, context: Context, mainActivity: MainActivity) {
        Singleton.recylerViewLeads = recylerViewLeads
        Singleton.context = context
        Singleton.mainActivity = mainActivity
    }

}