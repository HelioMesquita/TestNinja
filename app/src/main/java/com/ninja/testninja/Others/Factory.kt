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


        fun convertList(value:String):String{
            return value.replace("[","").replace("]","")
        }

        fun convertDistance(value: String):String{
            return "a " + (value.toInt()/1000).toString() + " km de voce"
        }


    }
}