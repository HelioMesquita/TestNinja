package com.ninja.testninja.Others


import org.junit.Assert.*
import org.junit.Test


class ConvertTest{
    lateinit var date:String
    lateinit var distance:String
    lateinit var list:String
    @Test
    fun testConvertDate1(){
        date = Convert.convertDate("2016-03-04T14:47:05.000+00:00")
        assertEquals("04 de mar",date)
    }

    @Test
    fun testConvertDate2(){
        date = Convert.convertDate("2016-02-04T14:43:06.000+00:00")
        assertEquals("04 de fev",date)
    }

    @Test
    fun testConvertDate3(){
        date = Convert.convertDate("2016-01-29T13:00:53.000+00:00")
        assertEquals("29 de jan",date)
    }

    @Test
    fun testConvertList1(){
        list = "[teste1,teste2]"
        assertEquals("teste1,teste2",Convert.convertList(list))
    }

    @Test
    fun testConvertList2(){
        list = "[teste1,teste2,teste4,teste3]"
        assertEquals("teste1,teste2,teste4,teste3",Convert.convertList(list))
    }

    @Test
    fun testConvertDistance1(){
        assertEquals("a 100 km de voce",Convert.convertDistance("100070"))
    }

    @Test
    fun testConvertDistance2(){
        assertEquals("a 100 km de voce",Convert.convertDistance("100070"))
    }
}