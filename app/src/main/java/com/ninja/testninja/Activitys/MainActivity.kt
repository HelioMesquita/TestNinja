package com.ninja.testninja.Activitys

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.ninja.testninja.Adapters.SectionsPageAdapter
import com.ninja.testninja.Fragments.LeadsFragment
import com.ninja.testninja.Fragments.OffersFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.DataClass.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RequestCallBack<StartLinks> {

    lateinit var offersFragment: OffersFragment
    lateinit var leadsFragment: LeadsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val a = SectionsPageAdapter(supportFragmentManager)

        offersFragment = OffersFragment()
        leadsFragment = LeadsFragment()

        setupViewPager(container)
        tabs.setupWithViewPager(container)

        val bar = toolbar.layoutParams as AppBarLayout.LayoutParams
        bar.scrollFlags = 0
        toolbar.layoutParams = bar

        WebClient.allResponse( "https://testemobile.getninjas.com.br/",this)
    }

    override fun OnSuccess(obj: StartLinks) {
        offersFragment.performRequest(obj as StartLinks)
        leadsFragment.performRequest(obj as StartLinks)
    }

    override fun onFail() {
        Toast.makeText(this, "Erro ao carregar", Toast.LENGTH_SHORT).show()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPageAdapter(supportFragmentManager)
        adapter.addFragment(offersFragment, "DISPONIVEL")
        adapter.addFragment(leadsFragment, "Aceitos")
        viewPager.adapter = adapter
        //tabs.getTabAt(0)!!.setIcon(R.drawable.ic_check)
        //tabs.getTabAt(1)!!.setIcon(R.drawable.ic_check)
    }
}
