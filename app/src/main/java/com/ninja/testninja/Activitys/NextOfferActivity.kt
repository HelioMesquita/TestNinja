package com.ninja.testninja.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.MenuItem
import com.ninja.testninja.R


class NextOfferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_offer)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.title = "Oferta"


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        return true
    }


    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
        return
    }



}
