package com.ninja.testninja.DataClass

import com.google.gson.annotations.SerializedName
import com.ninja.testninja.Others.Convert

data class Offers(val state:String,
                  @SerializedName("_embedded")
                  val embedded: _embedded,
                  val requesty: Requesty,
                  @SerializedName("_links")
                  val link: Link,
                  val href: String) {
    fun title(): String {
        return embedded.request.title
    }

    fun name(): String {
        return embedded.request.embedded.user.name
    }

    fun place(): String {
        val address = embedded.request.embedded.address
        return "${address.neighborhood} - ${address.city}"
    }

    fun state(): String {
        return state
    }

    fun data(): String {
        return Convert.convertDate(embedded.request.created_at)
    }

    fun link(): String {
        return link.self.href
    }
}
