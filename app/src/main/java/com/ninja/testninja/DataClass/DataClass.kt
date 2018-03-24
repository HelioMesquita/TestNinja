package com.ninja.testninja.DataClass

import com.google.gson.annotations.SerializedName
import com.ninja.testninja.Others.Convert

data class StartLinks(
        @SerializedName("_links")
        val link: Link)
{
    fun linkLeads(): String {
        return link.leads.href
    }
    fun linkOffer(): String {
        return link.offers.href
    }
}

data class Link(val leads: Leads,
                val offers: Offers,
                val self: Self,
                val accept: accept,
                val reject: reject)

data class Requesty(val title: String)

data class Self(val href: String)

data class request( val created_at: String,
                    val title: String,
                    @SerializedName("_embedded")
                    val embedded: _embedded)

data class _embedded(val request: request,
                     val address: Address,
                     val user: User,
                     val info: List<Info>,
                     val phones: List<Phones>)

data class Phones(val number: Any)

data class accept(val href: String)

data class reject(val href: String)

data class Address(val city: String,
                   val neighborhood: String,
                   val uf: String,
                   val street: String,
                   val geolocation: Geolocation)

data class User(val name: String,
                val email: String,
                @SerializedName("_embedded")
                val embedded: _embedded)

class OffersList(val offers: List<Offers>,
                 @SerializedName("_links")
                  val link: Link)
{
    fun linksOffer(): String{
        return link.self.href
    }
}

class LeadsList(val leads: List<Leads>,
                @SerializedName("_links")
                 val link: Link)
{
    fun linksLeads(): String{
        return link.self.href
    }
}

data class Info(val label: String,
                val value: Any)
{
    fun title(): String {
        return label
    }

    fun value(): String {
        return Convert.convertList(value.toString())
    }
}

data class Geolocation(val latitude: Double,val longitude: Double)
