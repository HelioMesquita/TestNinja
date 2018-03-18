package com.ninja.testninja.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ninja.testninja.Fragments.LeadsNextFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.PageNext
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R

class NextLeadsActivity : AppCompatActivity(), RequestCallBack {
    override fun onSuccess(obj: Any) {
        leadsNextFragment.popularFragment(obj)
        runOnUiThread {
            supportActionBar!!.title = (obj as PageNext).title
        }
    }

    override fun onFail() {

    }
    lateinit var leadsNextFragment: LeadsNextFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_leads)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)


        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        leadsNextFragment = LeadsNextFragment()
        ft.add(R.id.mainFragment, leadsNextFragment)
        ft.commit()

        WebClient.responseNextLeads(Singleton.leadsNextLinks, this)

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
