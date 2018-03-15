package com.ninja.testninja.Others

data class StartLinks(var _links: _links)
data class _links(val leads: Leads, val offers: Offers, val self: Self)
data class Resquest(val title:String)
data class Self(val href:String)
data class request( val created_at:String,val title:String,val _embedded: _embedded)
data class _embedded(val request: request, val address: Address, val user: User,val info:List<Info>,val phones:List<Phones>)
data class Phones(val number:Any)



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
//FAZER o LINKS tirando o val _embedded:_embedded
data class PageNext(val distance:String, val lead_price:String, val title:String, val _embedded:_embedded)

data class Info(val label:String,val value: Any)

data class Geolocation(val latitude:Double,val longitude:Double)


