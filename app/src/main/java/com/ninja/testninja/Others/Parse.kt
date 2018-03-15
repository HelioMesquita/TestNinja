package com.ninja.testninja.Others

import com.google.gson.GsonBuilder
import com.ninja.testninja.Interfaces.RequestCallBack



class Parse{
    companion object {
        fun parseInitial(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, StartLinks::class.java))
        }

        fun parseOffers(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, CreatOffers::class.java))
        }

        fun parseLeads(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, CreatLeads::class.java))
        }

        fun parseNextOffers(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, OffersNext::class.java))
        }


    }

}

