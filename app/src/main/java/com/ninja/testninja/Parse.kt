package com.ninja.testninja

import android.app.Activity
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.GsonBuilder


class Parse{
    private val gson = GsonBuilder().create()
    private lateinit var recyclerView: RecyclerView
    fun ParseInicial(body:String, recyclerView: RecyclerView, context: Context, activity: Activity){
        val obj = gson.fromJson(body, startLinks::class.java)

    }

    fun parseOffers(body: String?, recyclerView: RecyclerView, context: Context, activity: Activity) {
        val obj = gson.fromJson(body,CreatOffers::class.java)

        activity.runOnUiThread {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = OffersAdapter(obj)
        }
        //someTaskOffers(recyclerView,context,obj).execute()

    }

    fun parseLeads(body: String?) {
        val obj = gson.fromJson(body,CreatLeads::class.java)

    }


}

data class startLinks(val _links:_links)
data class _links(val leads:Leads,val offers:Offers,val self: Self)
data class Resquest(val title:String)
data class Self(val href:String)
data class request( val created_at:String,val title:String,val _embedded: _embedded)
data class _embedded(val request: request,val address: Address,val user: User)
data class Address(val city:String,val neighborhood:String,val uf:String,val street:String)
data class User(val name:String,val email:String)

class CreatOffers(val offers: List<Offers>,val _links: _links)
class CreatLeads(val leads:List<Leads>,val _links: _links)

data class Offers(val state:String,
                  val _embedded: _embedded,
                  val resquest: Resquest,
                  val _links: _links,
                  val href:String)

data class Leads( val created_at:String,
                  val _embedded:_embedded,
                  val resquest: Resquest,
                  val _links: _links,
                  val href:String)
