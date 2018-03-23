package com.ninja.testninja.Others

import com.google.gson.annotations.SerializedName

data class StartLinks(
        @SerializedName("_links")
        val links: _links)
{
    fun linksLeads():String{
        return links.leads.href
    }
    fun linksOffer():String{
        return links.offers.href
    }
}

data class _links(val leads: Leads,
                  val offers: Offers,
                  val self: Self,
                  val accept:accept,
                  val reject: reject)

data class Resquest(val title:String)

data class Self(val href:String)

data class request( val created_at:String,
                    val title:String,
                    @SerializedName("_embedded")
                    val embedded: _embedded)

data class _embedded(val request: request,
                     val address: Address,
                     val user: User,
                     val info:List<Info>,
                     val phones:List<Phones>)

data class Phones(val number:Any)

data class accept(val href: String)

data class reject(val href: String)

data class Address(val city:String,
                   val neighborhood:String,
                   val uf:String,
                   val street:String,
                   val geolocation:Geolocation)

data class User(val name:String,
                val email:String,
                @SerializedName("_embedded")
                val embedded: _embedded)

class CreatOffers(val offers: List<Offers>,
                  @SerializedName("_links")
                  val links: _links)
{
    fun currentOffer(index: Int): Offers {
        return offers[index]
    }
    fun linksOffer():String{
        return links.self.href
    }
}

class CreatLeads(val leads:List<Leads>,
                 @SerializedName("_links")
                 val links: _links)
{
    fun linksLeads():String{
        return links.self.href
    }

}

data class Offers(val state:String,
                  @SerializedName("_embedded")
                  val embedded: _embedded,
                  val resquest: Resquest,
                  @SerializedName("_links")
                  val links: _links,
                  val href: String)
{
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
        return Factory.convertDate(embedded.request.created_at)
    }

    fun links(): String {
        return links.self.href
    }
}

data class Leads(val created_at:String,
                 @SerializedName("_embedded")
                 val embedded: _embedded,
                 val resquest: Resquest,
                 @SerializedName("_links")
                 val links: _links,
                 val href: String)
{

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
        return Factory.convertDate(created_at)
    }

    fun links(): String {
        return links.self.href
    }


}

data class PageNext(val distance: String,
                    val lead_price: String,
                    val title: String,
                    @SerializedName("_embedded")
                    val embedded: _embedded,
                    @SerializedName("_links")
                    val links: _links)
{
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
        return Factory.convertDistance(distance)
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

    fun accept():String{
        return links.accept.href
    }

}

data class Info(val label: String,
                val value: Any)
{
    fun title(): String {
        return label
    }

    fun value(): String {
        return Factory.convertList(value.toString())
    }
}

data class Geolocation(val latitude:Double,val longitude:Double)
//@SerializedName("custom_naming")