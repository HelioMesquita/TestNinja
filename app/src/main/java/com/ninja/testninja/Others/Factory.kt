package com.ninja.testninja.Others

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class Factory{
    companion object {

        @SuppressLint("SimpleDateFormat")
        fun convertDate(date: String) : String {
            return SimpleDateFormat("dd-MMM")
                    .format(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm")
                            .parse(date)).replace("-"," de ")
        }

        fun convertCity(neighborhood:String,city:String):String{
            return "$neighborhood - $city"
        }

        fun convertList(value:String):String{
            return value.replace("[","").replace("]","")
        }

        fun convertDistance(value: String):String{
            return "a " + (value.toInt()/1000).toString() + " km de voce"
        }

        fun creatTextLeads(leads: Leads): TextAdapter {
            return TextAdapter(leads._embedded.request.title,leads._embedded.user.name,
                    Factory.convertCity(leads._embedded.address.neighborhood,
                            leads._embedded.address.city),
                            convertDate(leads.created_at),"")
        }

        fun creatTextOffers(offers: Offers): TextAdapter {
            return TextAdapter(offers._embedded.request.title, offers._embedded.request._embedded.user.name,
                    Factory.convertCity(offers._embedded.request._embedded.address.neighborhood,
                            offers._embedded.request._embedded.address.city),
                    convertDate(offers._embedded.request.created_at),offers.state)
        }

        fun creatNextText(info: Info): TextNextAdapter {
            return TextNextAdapter(info.label, convertList(info.value.toString()))
        }

        fun creatNext(pageNext: PageNext) : TextNext{
            return TextNext(pageNext.title,pageNext._embedded.user.name,
                    convertCity(pageNext._embedded.address.neighborhood,pageNext._embedded.address.city),
                    pageNext._embedded.user.email, convertDistance(pageNext.distance)
                    ,convertList(pageNext._embedded.user._embedded.phones[0].number.toString()))
        }


    }
}