package com.ninja.testninja.Activitys

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ninja.testninja.Fragments.OffersNextFragment
import com.ninja.testninja.Interfaces.ManageFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.PageNext
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.activity_next_offer.*


class NextOfferActivity : AppCompatActivity(), RequestCallBack, ManageFragment {
    override fun title(title:String) {
        runOnUiThread {
            supportActionBar!!.title = title
        }
    }

    override fun commit() {
        supportFragmentManager.beginTransaction()
                .add(R.id.mainFragment, offersNextFragment).commit()
    }

    override fun onSuccess(obj: Any) {
        offersNextFragment.popularFragment(obj)
        title((obj as PageNext).title())
        pageNext = obj as PageNext
    }

    override fun onFail() {

    }

    lateinit var pageNext: PageNext
    lateinit var offersNextFragment: OffersNextFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_offer)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        offersNextFragment = OffersNextFragment()

        commit()

        WebClient.responseNextOffers(intent.getStringExtra("links"), this)

        buttonRecusar.setOnClickListener {
            finish()
        }

        buttonAceitar.setOnClickListener {
            startActivity(Intent(this,NextLeadsActivity::class.java)
                    .putExtra("links",pageNext.accept()))
            finish()
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
