package com.ninja.testninja.Others

import com.ninja.testninja.Interfaces.RequestCallBack
import okhttp3.*
import java.io.IOException


class WebClient {

    companion object {

       inline fun <reified T> allResponse(url: String, delegate: RequestCallBack<T>) {
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
