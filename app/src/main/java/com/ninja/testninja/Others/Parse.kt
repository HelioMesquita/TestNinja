package com.ninja.testninja.Others

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.ninja.testninja.DataClass.Detail
import com.ninja.testninja.DataClass.LeadsList
import com.ninja.testninja.DataClass.OffersList
import com.ninja.testninja.DataClass.StartLinks
import com.ninja.testninja.Interfaces.NewInterfaceTest
import com.ninja.testninja.Interfaces.RequestCallBack

class Parse{
    companion object {
        fun parseInitial(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, StartLinks::class.java))
        }

        fun parseOffers(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, OffersList::class.java))
        }

        fun parseLeads(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, LeadsList::class.java))
        }

        fun parseNext(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, Detail::class.java))
        }

        inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

        /**
         * val turns = Gson().fromJson<FullLoadParts>(a)

           val turnss: FullLoadParts = Gson().fromJson(a)
         */

        inline fun <reified T> parseGeneric(body:String, delegate: NewInterfaceTest<T>) {
            delegate.sucesso(Gson().fromJson(body))
        }
    }
}
