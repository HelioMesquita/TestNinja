package com.ninja.testninja.Activitys

import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.Others._links
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class MainActivityTest  : RequestCallBack{

    //@After
    override fun onSuccess(obj: Any) {
        assertNotNull(obj)
        val startLinks = obj as StartLinks
        assertEquals("http://testemobile.getninjas.com.br/leads",startLinks._links.leads.href)
        assertEquals("http://testemobile.getninjas.com.br/offers",startLinks._links.offers.href)





    }

    override fun onFail() {

    }

    @Test
    fun requestInitial() {
        WebClient.requestInitial(this, "https://testemobile.getninjas.com.br/")





    }

}