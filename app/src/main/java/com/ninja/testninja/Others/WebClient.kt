package com.ninja.testninja.Others

import com.ninja.testninja.Interfaces.RequestCallBack
import okhttp3.*
import java.io.IOException


class WebClient {
    companion object {
        fun requestInitial(delegate: RequestCallBack, url: String) {
            OkHttpClient().newCall(Request.Builder().url(url).build()).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    Parse.parseInitial(response!!.body()!!.string()!!, delegate)
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    delegate.onFail()
                }
            })
        }

        fun responseOffers(obj: StartLinks, delegate: RequestCallBack) {
            OkHttpClient()
                    .newCall(Request.Builder()
                            .url(obj._links.offers.href)
                            .build()).enqueue(object : Callback {
                        override fun onResponse(call: Call?, response: Response?) {
                            Parse.parseOffers(response!!.body()!!.string()!!, delegate)

                        }

                        override fun onFailure(call: Call?, e: IOException?) {
                            delegate.onFail()
                        }
                    })
        }

        fun responseLeads(obj: StartLinks, delegate: RequestCallBack) {
            OkHttpClient()
                    .newCall(Request.Builder()
                            .url(obj._links.leads.href)
                            .build()).enqueue(object : Callback {
                        override fun onResponse(call: Call?, response: Response?) {
                            Parse.parseLeads(response!!.body()!!.string()!!, delegate)

                        }

                        override fun onFailure(call: Call?, e: IOException?) {
                            delegate.onFail()
                        }
                    })
        }

        fun responseNextOffers(obj: Offers, delegate: RequestCallBack) {
            OkHttpClient()
                    .newCall(Request.Builder()
                            .url(obj._links.self.href)
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
            OkHttpClient()
                    .newCall(Request.Builder()
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


    }


}