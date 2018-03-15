package com.ninja.testninja.Others

import com.google.gson.GsonBuilder
import com.ninja.testninja.Interfaces.RequestCallBack
import okhttp3.*
import java.io.IOException


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

        fun parseNext(body: String, delegate: RequestCallBack) {
            delegate.onSuccess(GsonBuilder().create().fromJson(body, PageNext::class.java))
        }


    }

}

