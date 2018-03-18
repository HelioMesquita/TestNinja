package com.ninja.testninja.Activitys

import android.content.Context
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.Others._links
import com.ninja.testninja.R
import org.hamcrest.core.Is.`is`
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify


@RunWith(MockitoJUnitRunner::class)
class MainActivityTest  : RequestCallBack{
    init {
        //mMockContext
    }

    //lateinit var mMockContext:Context
    //@After
    override fun onSuccess(obj: Any) {
        assertNotNull(obj)
        startLinks = obj as StartLinks
        assertEquals("http://testemobile.getninjas.com.br/leads",startLinks._links.leads.href)
        assertEquals("http://testemobile.getninjas.com.br/offers",startLinks._links.offers.href)





    }

    override fun onFail() {

    }

    lateinit var startLinks: StartLinks

    @Test
    fun requestInitial() {
        val a = Mockito.mock(WebClient::class.java)
        WebClient.requestInitial(this, "https://testemobile.getninjas.com.br/")
        verify(a)


    }

}

