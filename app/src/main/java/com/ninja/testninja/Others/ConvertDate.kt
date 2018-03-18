package com.ninja.testninja.Others

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class ConvertDate{
    companion object {
        @SuppressLint("SimpleDateFormat")
        fun convet(date: String) : String {
            return SimpleDateFormat("dd-MMM")
                    .format(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm")
                            .parse(date)).replace("-"," de ")
        }
    }
}