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

    }
}