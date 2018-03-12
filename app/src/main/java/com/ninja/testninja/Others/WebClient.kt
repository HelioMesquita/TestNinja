package com.ninja.testninja.Others

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.ninja.testninja.Activitys.NextOfferActivity
import okhttp3.*
import java.io.IOException


class WebClient{
    private val client = OkHttpClient()
    private var body: String? = null
    private val ERRO="erro"
    private val parse = Parse()
    fun requestInicial(url:String, RecyclerView: RecyclerView,context: Context,activity: Activity){
        responseStart(url, RecyclerView,context,activity) // gson q vai desmenbrar

    }

    fun responseStart(url: String, RecyclerView: RecyclerView,context: Context,activity: Activity){
        val request = Request.Builder()
                .url(url)
                .build()
        val response = client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?){
                body = response!!.body()!!.string()!!
                parse.ParseInicial(body!!, RecyclerView,context,activity)

            }
            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(ERRO,ERRO)
                responseStart(url, RecyclerView,context,activity)
            }
        })
    }

    fun responseLeads(url: String){
        val request = Request.Builder()
                .url(url)
                .build()
        val response = client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?){
                body = response!!.body()!!.string()!!
                parse.parseLeads(body)

            }
            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(ERRO,ERRO)
                responseLeads(url)
            }
        })
    }

    fun responseOffers(url: String, recyclerView: RecyclerView,context:Context,activity:Activity){
        val request = Request.Builder()
                .url(url)
                .build()
        val response = client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?){
                body = response!!.body()!!.string()!!
                parse.parseOffers(body,recyclerView,context,activity)

            }
            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(ERRO,ERRO)
                responseOffers(url, recyclerView,context,activity)
            }
        })
    }

    fun responseNextOffers(url: String, recyclerView: RecyclerView, context: Context, nextOfferActivity: NextOfferActivity){
        val request = Request.Builder()
                .url(url)
                .build()
        val response = client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?){
                body = response!!.body()!!.string()!!
                parse.parseNextOffers(body!!,context,nextOfferActivity,recyclerView)
                println(body)

            }
            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(ERRO,ERRO)
            }
        })
    }



}