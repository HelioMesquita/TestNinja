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

class CreatOffers(val offers: List<Offers>, val _links: _links)
class CreatLeads(val leads:List<Leads>, val _links: _links)

data class Offers(val state:String,
                  val _embedded: _embedded,
                  val resquest: Resquest,
                  val _links: _links,
                  val href:String)

data class Leads(val created_at:String,
                 val _embedded: _embedded,
                 val resquest: Resquest,
                 val _links: _links,
                 val href:String)

data class PageNext(val distance:String, val lead_price:String, val title:String, val _embedded:_embedded,val _links: _links)

data class Info(val label:String,val value: Any)

data class Geolocation(val latitude:Double,val longitude:Double)

data class TextAdapter(val title:String, val name:String, val place:String, val date:String,val state: String)
data class TextNextAdapter(val title: String, val value:String)
data class TextNext(val title:String,val name:String,val place:String, val email:String,val distance:String,val number:String)