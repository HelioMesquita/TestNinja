package com.ninja.testninja.Activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ninja.testninja.Fragments.OffersNextFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.activity_next_offer.*


class NextOfferActivity : AppCompatActivity(), RequestCallBack {
    override fun onSuccess(obj: Any) {
        offersNextFragment.popularFragment(obj)

    }

    override fun onFail() {

    }

    lateinit var offersNextFragment: OffersNextFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_offer)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.title = "Oferta"

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        offersNextFragment = OffersNextFragment()
        ft.add(R.id.mainFragment, offersNextFragment)
        ft.commit()



        WebClient.responseNextOffers(Singleton.offersNext, this)





        buttonRecusar.setOnClickListener {
            println("testestes")
        }


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
