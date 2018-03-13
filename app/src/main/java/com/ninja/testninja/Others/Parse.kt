package com.ninja.testninja.Others

import android.app.Activity
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.ninja.testninja.Activitys.NextOfferActivity
import com.ninja.testninja.Adapters.LeadsAdapter
import com.ninja.testninja.Adapters.OffersAdapter
import com.ninja.testninja.Adapters.OffersNextAdapter
import kotlinx.android.synthetic.main.fragment_offers_next.view.*


class Parse{
    private val gson = GsonBuilder()
            .create()
    //private lateinit var recyclerView: RecyclerView
    fun ParseInicial(body:String, recyclerView: RecyclerView, context: Context, activity: Activity){
        val obj = gson.fromJson(body, startLinks::class.java)
        Singleton.mainLinks =obj
        WebClient().responseOffers(obj._links.offers.href,recyclerView,context,activity)
        WebClient().responseLeads(obj._links.leads.href)
    }

    fun parseOffers(body: String?, recyclerView: RecyclerView, context: Context, activity: Activity) {
        val obj = gson.fromJson(body, CreatOffers::class.java)
        Singleton.offers =obj
        activity.runOnUiThread {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = OffersAdapter(obj)
        }
        //someTaskOffers(recyclerView,context,obj).execute()

    }

    fun parseLeads(body: String?) {
        val obj = gson.fromJson(body, CreatLeads::class.java)
        Singleton.leads = obj
        Singleton.mainActivity.runOnUiThread {
            Singleton.recylerViewLeads.layoutManager = LinearLayoutManager(Singleton.context)
            Singleton.recylerViewLeads.adapter = LeadsAdapter(obj)
        }

    }

    fun parseNextOffers(body: String, context: Context, nextOfferActivity: NextOfferActivity, recyclerNextView: RecyclerView) {
        val obj = gson.fromJson(body, OffersNext::class.java)





        nextOfferActivity.runOnUiThread {
            recyclerNextView.layoutManager = LinearLayoutManager(context)
            recyclerNextView.recyclerView.adapter = OffersNextAdapter(obj)
        }



    }



//

}

