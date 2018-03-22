package com.ninja.testninja.Others

data class StartLinks(var _links: _links)
data class _links(val leads: Leads, val offers: Offers, val self: Self, val accept:accept, val reject: reject)
data class Resquest(val title:String)
data class Self(val href:String)
data class request( val created_at:String,val title:String,val _embedded: _embedded)
data class _embedded(val request: request, val address: Address, val user: User,val info:List<Info>,val phones:List<Phones>)
data class Phones(val number:Any)
data class accept(val href: String)
data class reject(val href: String)

data class Address(val city:String,val neighborhood:String,val uf:String,val street:String,val geolocation:Geolocation)
data class User(val name:String,val email:String,val _embedded: _embedded)

class CreatOffers(val offers: List<Offers>, val _links: _links) {
    fun currentOffer(index: Int): Offers {
        return offers[index]
    }
}
class CreatLeads(val leads:List<Leads>, val _links: _links)

data class Offers(val state:String,
                  val _embedded: _embedded,
                  val resquest: Resquest,
                  val _links: _links,
                  val href: String) {
    fun title(): String {
        return _embedded.request.title
    }

    fun name(): String {
        return _embedded.request._embedded.user.name
    }

    fun place(): String {
        val address = _embedded.request._embedded.address
        return "${address.neighborhood} - ${address.city}"
    }

    fun state(): String {
        return state
    }

    fun data(): String {
        return Factory.convertDate(_embedded.request.created_at)
    }
}

data class Leads(val created_at:String,
                 val _embedded: _embedded,
                 val resquest: Resquest,
                 val _links: _links,
                 val href: String) {

    fun title(): String {
        return _embedded.request.title
    }

    fun name(): String {
        return _embedded.user.name
    }

    fun place(): String {
        val address = _embedded.address
        return "${address.street} - ${address.city}"
    }

    fun data(): String {
        return Factory.convertDate(created_at)
    }
}

data class PageNext(val distance: String, val lead_price: String, val title: String, val _embedded: _embedded, val _links: _links) {
    fun title(): String {
        return title
    }

    fun name(): String {
        return _embedded.user.name
    }

    fun place(): String {
        val address = _embedded.address
        return "${address.neighborhood} - ${address.city}"
    }

    fun email(): String {
        return _embedded.user.email
    }

    fun distance(): String {
        return Factory.convertDistance(distance)
    }

    fun number(): String {
        return _embedded.user._embedded.phones[0].number.toString()
    }

    /**
     * view!!.textViewTitleFragmet.text = textNext.title
    view!!.textViewClient.text = textNext.name
    view!!.textViewLocal.text = textNext.place
    view!!.textViewEmail.text = textNext.email
    view!!.textViewDistance.text = textNext.distance
    view!!.textViewNumber.text = textNext.number
     */
}

data class Info(val label: String, val value: Any) {
    fun title(): String {
        return label
    }

    fun value(): String {
        return Factory.convertList(value.toString())
    }
}

data class Geolocation(val latitude:Double,val longitude:Double)

data class TextAdapter(val title:String, val name:String, val place:String, val date:String,val state: String)
data class TextNextAdapter(val title: String, val value:String)
data class TextNext(val title:String,val name:String,val place:String, val email:String,val distance:String,val number:String)