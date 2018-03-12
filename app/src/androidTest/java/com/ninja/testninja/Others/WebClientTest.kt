package com.ninja.testninja.Others
/**
import android.app.Activity
import com.ninja.testninja.Activitys.MainActivity
import com.ninja.testninja.BuildConfig
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import org.robolectric.RobolectricTestRunner



@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class WebClientTest : Robolectric() {
    lateinit var activity:Activity
    @Before
    fun getActivit(){
        val activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun ShowNotNoll(){
        Assert.assertNotNull(activity)
    }


    @Test
    fun requestInicial() {

    }

    @Test
    fun responseStart() {
    }

    @Test
    fun responseLeads() {
    }

    @Test
    fun responseOffers() {
    }

    @Test
    fun responseNextOffers() {
    }

}
    **/