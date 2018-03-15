package com.ninja.testninja.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ninja.testninja.Fragments.LeadsNextFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R

class NextLeadsActivity : AppCompatActivity(), RequestCallBack {
    override fun onSuccess(obj: Any) {
        leadsNextFragment.popularFragment(obj)
    }

    override fun onFail() {

    }
    lateinit var leadsNextFragment: LeadsNextFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_leads)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.title = Singleton.leadsNext._embedded.user.name

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        leadsNextFragment = LeadsNextFragment()
        ft.add(R.id.mainFragment, leadsNextFragment)
        ft.commit()


        WebClient.responseNextLeads(Singleton.leadsNext, this)



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
