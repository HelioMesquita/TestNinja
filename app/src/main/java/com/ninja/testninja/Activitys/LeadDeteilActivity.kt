package com.ninja.testninja.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.ninja.testninja.Fragments.LeadDetailFragment
import com.ninja.testninja.Interfaces.ManageFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.DataClass.Detail
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R

class LeadDeteilActivity : AppCompatActivity(), RequestCallBack, ManageFragment {

    lateinit var leadDetailFragment: LeadDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_leads)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        leadDetailFragment = LeadDetailFragment()

        commit()

        WebClient.responseNextLeads(intent.getStringExtra("link"), this)
    }

    override fun title(title:String) {
        runOnUiThread {
            supportActionBar!!.title = title
        }
    }

    override fun commit() {
        supportFragmentManager.beginTransaction()
                .add(R.id.mainFragment, leadDetailFragment).commit()
    }

    override fun onSuccess(obj: Any) {
        leadDetailFragment.popularFragment(obj)
        title((obj as Detail).title())
    }

    override fun onFail() {
        Toast.makeText(this, "Erro ao carregar",Toast.LENGTH_SHORT).show()
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
