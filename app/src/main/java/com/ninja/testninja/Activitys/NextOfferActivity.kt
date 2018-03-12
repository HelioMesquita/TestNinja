package com.ninja.testninja.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ninja.testninja.Fragments.OffersNextFragment
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.R


class NextOfferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_offer)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.title = "Oferta"

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        val nextFragment = OffersNextFragment()
        ft.add(R.id.mainFragment,nextFragment)
        ft.commit()


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }


    override fun onBackPressed() {
        finish()
        return
    }



}
