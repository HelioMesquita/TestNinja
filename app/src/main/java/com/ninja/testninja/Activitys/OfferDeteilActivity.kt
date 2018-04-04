package com.ninja.testninja.Activitys

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.ninja.testninja.Fragments.OfferDetailFragment
import com.ninja.testninja.Interfaces.ManageFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.DataClass.Detail
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.activity_detail_offer.*

class OfferDeteilActivity : AppCompatActivity(), ManageFragment, RequestCallBack<Detail> {

    lateinit var detail: Detail
    lateinit var offerDetailFragment: OfferDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_offer)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        offerDetailFragment = OfferDetailFragment()

        commit()

        WebClient.allResponse(intent.getStringExtra("link"), this)

        buttonRecusar.setOnClickListener {
            finish()
        }

        buttonAceitar.setOnClickListener {
            startActivity(Intent(this,LeadDeteilActivity::class.java)
                    .putExtra("link",detail.accept()))
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

    override fun OnSuccess(obj: Detail) {
        offerDetailFragment.popularFragment(obj)
        title(obj.title())
        detail = obj
    }

    override fun onFail() {
        Toast.makeText(this, "Erro ao carregar", Toast.LENGTH_SHORT).show()
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
