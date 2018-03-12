package com.ninja.testninja.Others


import okhttp3.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException


class WebClientTest {
    lateinit var webClient:WebClient
    private val client = OkHttpClient()
    @Before
    fun setUp(){
        webClient= WebClient()
    }

    @Test
    fun notNull(){
        assertNotNull(webClient)
    }


    @Test
    fun requestInicial() {

    }

    @Test
    fun responseStart() {

    }

    @Test
    fun responseLeads(url: String) {
        val url = "http://testemobile.getninjas.com.br/leads"

    }

    @Test
    fun responseOffers() {
    }

    @Test
    fun responseNextOffers() {
    }

}
