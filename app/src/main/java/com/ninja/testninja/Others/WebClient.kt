package com.ninja.testninja.Others

import com.ninja.testninja.Interfaces.NewInterfaceTest
import com.ninja.testninja.Interfaces.RequestCallBack
import okhttp3.*
import java.io.IOException


class WebClient {
    companion object {
        fun requestInitial(delegate: RequestCallBack, url: String) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseInitial(response!!.body()!!.string()!!, delegate)
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        fun responseOffers(url: String, delegate: RequestCallBack) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseOffers(response!!.body()!!.string()!!, delegate)
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        fun responseLeads(url: String, delegate: RequestCallBack) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseLeads(response!!.body()!!.string()!!, delegate)
                }
                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        fun responseLeadsRefresh(url: String, delegate: RequestCallBack) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseLeads(response!!.body()!!.string()!!, delegate)
                }
                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        fun responseOffersRefresh(url: String, delegate: RequestCallBack) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseOffers(response!!.body()!!.string()!!, delegate)
                }
                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        fun responseNextOffers(url: String, delegate: RequestCallBack) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseNext(response!!.body()!!.string()!!, delegate)
                }
                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        fun responseNextLeads(url: String, delegate: RequestCallBack) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseNext(response!!.body()!!.string()!!, delegate)
                }
                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        inline fun <reified T> allResponse(url: String, delegate: NewInterfaceTest<T>) {
            OkHttpClient().newCall(Request.Builder()
                    .url(url)
                    .build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseGeneric<T>(response!!.body()!!.string()!!, delegate)
                }
                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }
    }
}
