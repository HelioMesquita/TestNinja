package com.ninja.testninja.Others

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ninja.testninja.Interfaces.RequestCallBack

class Parse{

    companion object {

        inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

        inline fun <reified T> parseGeneric(body:String, delegate: RequestCallBack<T>) {
            delegate.OnSuccess(Gson().fromJson(body))
        }
    }
}
