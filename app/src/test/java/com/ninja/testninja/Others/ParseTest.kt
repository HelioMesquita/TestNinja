package com.ninja.testninja.Others

import com.ninja.testninja.Interfaces.RequestCallBack
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class ParseTest : RequestCallBack{
    override fun onSuccess(obj: Any) {
        when (cont){
            1 -> startLinks = obj as StartLinks
            2 -> offers = obj as CreatOffers
        }
        cont+=1

    }

    override fun onFail() {

    }

    lateinit var startLinks : StartLinks
    lateinit var offers: CreatOffers
    lateinit var gson:String
    var cont = 1

    @Before
    fun setUp() {
        gson="{\n" +
                "   \"_links\" : {\n" +
                "      \"leads\" : {\n" +
                "         \"href\" : \"http://testemobile.getninjas.com.br/leads\"\n" +
                "      },\n" +
                "      \"offers\" : {\n" +
                "         \"href\" : \"http://testemobile.getninjas.com.br/offers\"\n" +
                "      }\n" +
                "   }\n" +
                "}"

        Parse.parseInitial(gson,this)


        gson = "{\n" +
                "  \"offers\": [\n" +
                "    {\n" +
                "      \"state\": \"read\",\n" +
                "      \"_embedded\": {\n" +
                "        \"request\": {\n" +
                "          \"created_at\": \"2016-03-04T14:47:05.000+00:00\",\n" +
                "          \"title\": \"Buffet Completo\",\n" +
                "          \"_embedded\": {\n" +
                "            \"user\": {\n" +
                "              \"name\": \"Eduardo L'Hotellier\"\n" +
                "            },\n" +
                "            \"address\": {\n" +
                "              \"city\": \"São Paulo\",\n" +
                "              \"neighborhood\": \"Vila Leopoldina\",\n" +
                "              \"uf\": \"SP\"\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"_links\": {\n" +
                "        \"self\": {\n" +
                "          \"href\": \"https://testemobile.getninjas.com.br/offer-1\"\n" +
                "        }\n" +
                "      }\n" +
                "    }]\n" +
                "}"

        Parse.parseOffers(gson,this)


    }

    @Test
    fun notNull(){
        assertNotNull(startLinks)
        assertNotNull(offers)
    }

    @Test
    fun leadsTrueTrue(){
        assertEquals("http://testemobile.getninjas.com.br/leads",startLinks._links.leads.href)
    }

    @Test
    fun leadsFalseTrue(){
        assertNotEquals("http://testemobile.getninjas.com.br/leaads",startLinks._links.leads.href)
    }

    @Test
    fun offersTrueTrue(){
        assertEquals("http://testemobile.getninjas.com.br/offers",startLinks._links.offers.href)
    }

    @Test
    fun offersFalseTrue(){
        assertNotEquals("http://testemobile.getninjas.com.br/offerss",startLinks._links.offers.href)
    }

    @Test
    fun offersOffersTrueTrue(){
        assertEquals("read",offers.offers[0].state)
    }

    @Test
    fun offersOffersFalseTrue(){
        assertNotEquals("readd",offers.offers[0].state)
    }




}