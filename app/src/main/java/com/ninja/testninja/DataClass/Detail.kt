package com.ninja.testninja.DataClass

import com.google.gson.annotations.SerializedName
import com.ninja.testninja.Others.Convert

data class Detail(val distance: String,
                  val lead_price: String,
                  val title: String,
                  @SerializedName("_embedded")
                  val embedded: _embedded,
                  @SerializedName("_links")
                  val link: Link) {
    fun title(): String {
        return title
    }

    fun name(): String {
        return embedded.user.name
    }

    fun place(): String {
        val address = embedded.address
        return "${address.neighborhood} - ${address.city}"
    }

    fun email(): String {
        return embedded.user.email
    }

    fun distance(): String {
        return Convert.convertDistance(distance)
    }

    fun number(): String {
        return embedded.user.embedded.phones[0].number.toString()
    }

    fun latitude(): Double {
        return embedded.address.geolocation.latitude
    }

    fun longitude(): Double {
        return embedded.address.geolocation.longitude
    }

    fun accept(): String{
        return link.accept.href
    }
}
