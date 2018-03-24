package com.ninja.testninja.Activitys

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ninja.testninja.Fragments.OfferDetailFragment
import com.ninja.testninja.Interfaces.ManageFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.Deteil
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.activity_next_offer.*

class OfferDeteilActivity : AppCompatActivity(), RequestCallBack, ManageFragment {

    lateinit var deteil: Deteil
    lateinit var offerDetailFragment: OfferDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_offer)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        offerDetailFragment = OfferDetailFragment()

        commit()

        WebClient.responseNextOffers(intent.getStringExtra("link"), this)

        buttonRecusar.setOnClickListener {
            finish()
        }

        buttonAceitar.setOnClickListener {
            startActivity(Intent(this,LeadDeteilActivity::class.java)
                    .putExtra("link",deteil.accept()))
            finish()
        }
    }

    override fun title(title:String) {
        runOnUiThread {
            supportActionBar!!.title = title
        }
    }

    override fun commit() {
        supportFragmentManager.beginTransaction()
                .add(R.id.mainFragment, offerDetailFragment).commit()
    }

    override fun onSuccess(obj: Any) {
        offerDetailFragment.popularFragment(obj)
        title((obj as Deteil).title())
        deteil = obj as Deteil
    }

    override fun onFail() {

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
