package com.ninja.testninja.Others

import com.ninja.testninja.DataClass.Detail
import com.ninja.testninja.DataClass.LeadsList
import com.ninja.testninja.DataClass.OffersList
import com.ninja.testninja.DataClass.StartLinks
import com.ninja.testninja.Interfaces.RequestCallBack
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class ParseTest : RequestCallBack{
    override fun onSuccess(obj: Any) {
        when (cont){
            1 -> startLinks = obj as StartLinks
            2 -> offersList = obj as OffersList
            3 -> leadsList = obj as LeadsList
            4 -> next = obj as Detail
        }
        cont+=1

    }

    override fun onFail() {

    }

    lateinit var startLinks : StartLinks
    lateinit var offersList: OffersList
    lateinit var gson:String
    lateinit var leadsList: LeadsList
    lateinit var next: Detail
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
                "  \"offers\":[\n" +
                "    {\n" +
                "      \"state\":\"read\",\n" +
                "      \"_embedded\":{\n" +
                "        \"request\":{\n" +
                "          \"created_at\":\"2016-03-04T14:47:05.000+00:00\",\n" +
                "          \"title\":\"Buffet Completo\",\n" +
                "          \"_embedded\":{\n" +
                "            \"user\":{\n" +
                "              \"name\":\"Eduardo L'Hotellier\"\n" +
                "            },\n" +
                "            \"address\":{\n" +
                "              \"city\":\"São Paulo\",\n" +
                "              \"neighborhood\":\"Vila Leopoldina\",\n" +
                "              \"uf\":\"SP\"\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"_links\":{\n" +
                "        \"self\":{\n" +
                "          \"href\":\"https://testemobile.getninjas.com.br/offer-1\"\n" +
                "        }\n" +
                "      }\n" +
                "    }]\n" +
                "}"

        Parse.parseOffers(gson,this)

        gson = "{\n" +
                "  \"leads\":[\n" +
                "    {\n" +
                "      \"created_at\":\"2016-03-04T14:47:05.000+00:00\",\n" +
                "      \"_embedded\":{\n" +
                "        \"address\":{\n" +
                "          \"city\":\"São Paulo\",\n" +
                "          \"street\":\"Avenida Imperatriz Leopoldina\",\n" +
                "          \"neighborhood\":\"Vila Leopoldina\",\n" +
                "          \"uf\":\"SP\"\n" +
                "        },\n" +
                "        \"user\":{\n" +
                "          \"name\":\"Eduardo L'Hotellier\",\n" +
                "          \"email\":\"eduardo@hotmail.com\"\n" +
                "        },\n" +
                "        \"request\":{\n" +
                "          \"title\":\"Buffet Completo\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"_links\":{\n" +
                "        \"self\":{\n" +
                "          \"href\":\"https://testemobile.getninjas.com.br/lead-1\"\n" +
                "        }\n" +
                "      }\n" +
                "    }]\n" +
                "}"

        Parse.parseLeads(gson,this)

        gson = "{\n" +
                "  \"distance\":100070,\n" +
                "  \"lead_price\":1,\n" +
                "  \"title\":\"Buffet Completo\",\n" +
                "  \"_embedded\":{\n" +
                "    \"info\":[\n" +
                "      {\n" +
                "        \"label\":\"Informações Adicionais\",\n" +
                "        \"value\":\"N/A\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"user\":{\n" +
                "      \"name\":\"Eduardo L'Hotellier\",\n" +
                "      \"email\":\"eduardo@hotmail.com\",\n" +
                "      \"_embedded\":{\n" +
                "        \"phones\":[\n" +
                "          {\n" +
                "            \"number\":\"(11) 3791-7315\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    },\n" +
                "    \"address\":{\n" +
                "      \"city\":\"São Paulo\",\n" +
                "      \"neighborhood\":\"Vila Leopoldina\",\n" +
                "      \"uf\":\"SP\",\n" +
                "      \"geolocation\":{\n" +
                "        \"latitude\":-23.5304898,\n" +
                "        \"longitude\":-46.7261564\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"_links\":{\n" +
                "    \"accept\":{\n" +
                "      \"href\":\"https://testemobile.getninjas.com.br/lead-1\"\n" +
                "    },\n" +
                "    \"reject\":{\n" +
                "      \"href\":\"https://testemobile.getninjas.com.br/offers\"\n" +
                "    }\n" +
                "  }\n" +
                "}"

        Parse.parseNext(gson,this)

    }

    @Test
    fun notNullStarLinks(){
        assertNotNull(startLinks)
    }

    @Test
    fun notNullOffers(){
        assertNotNull(offersList)
    }

    @Test
    fun notNullLeads(){
        assertNotNull(leadsList)
    }

    @Test
    fun notNullNext(){
        assertNotNull(next)
    }

    @Test
    fun leadsLinksLeads(){
        assertEquals("http://testemobile.getninjas.com.br/leads",startLinks.linkLeads())
    }

    @Test
    fun offersLinksOffer(){
        assertEquals("http://testemobile.getninjas.com.br/offers",startLinks.linkOffer())
    }

    @Test
    fun offersTitle(){
        assertEquals("Buffet Completo",offersList.offers[0].title())
    }

    @Test
    fun offersName(){
        assertEquals("Eduardo L'Hotellier",offersList.offers[0].name())
    }

    @Test
    fun offersPlace(){
        assertEquals("Vila Leopoldina - São Paulo",offersList.offers[0].place())
    }

    @Test
    fun offersState(){
        assertEquals("read",offersList.offers[0].state())
    }

    @Test
    fun offersDate(){
        assertEquals("04 de mar",offersList.offers[0].data())
    }

    @Test
    fun offersLinks(){
        assertEquals("https://testemobile.getninjas.com.br/offer-1",offersList.offers[0].link())
    }

    @Test
    fun leadsTitle(){
        assertEquals("Buffet Completo",leadsList.leads.first().title())
    }

    @Test
    fun leadsName(){
        assertEquals("Eduardo L'Hotellier",offersList.offers.first().name())
    }

    @Test
    fun leadsPlace(){
        assertEquals("Vila Leopoldina - São Paulo",offersList.offers[0].place())
    }

    @Test
    fun leadsState(){
        assertEquals("read",offersList.offers[0].state())
    }

    @Test
    fun leadsDate(){
        assertEquals("04 de mar",offersList.offers[0].data())
    }

    @Test
    fun leadsLinks(){
        assertEquals("https://testemobile.getninjas.com.br/offer-1",offersList.offers[0].link())
    }

    @Test
    fun nextTitle(){
        assertEquals("Buffet Completo",next.title())
    }

    @Test
    fun nextName(){
        assertEquals("Eduardo L'Hotellier",next.name())
    }

    @Test
    fun nextPlace(){
        assertEquals("Vila Leopoldina - São Paulo",next.place())
    }

    @Test
    fun nextEmail(){
        assertEquals("eduardo@hotmail.com",next.email())
    }

    @Test
    fun nextDistance(){
        assertEquals("a 100 km de voce",next.distance())
    }

    @Test
    fun nextNumber(){
        assertEquals("(11) 3791-7315",next.number())
    }

    @Test
    fun nextLatitude(){
        assertEquals(-23.5304898,next.latitude(),0.0)
    }

    @Test
    fun nextLongitude(){
        assertEquals(-46.7261564,next.longitude(),0.0)
    }

    @Test
    fun nextAccept(){
        assertEquals("https://testemobile.getninjas.com.br/lead-1",next.accept())
    }

}