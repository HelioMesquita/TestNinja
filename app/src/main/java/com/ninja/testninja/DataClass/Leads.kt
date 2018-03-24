package com.ninja.testninja.DataClass

import com.google.gson.annotations.SerializedName
import com.ninja.testninja.Others.Convert

data class Leads(val created_at: String,
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
        return embedded.user.name
    }

    fun place(): String {
        val address = embedded.address
        return "${address.neighborhood} - ${address.city}"
    }

    fun data(): String {
        return Convert.convertDate(created_at)
    }

    fun link(): String {
        return link.self.href
    }
}
