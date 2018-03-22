package com.ninja.testninja.Activitys

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.ninja.testninja.Adapters.SectionsPageAdapter
import com.ninja.testninja.Fragments.LeadsFragment
import com.ninja.testninja.Fragments.OffersFragment
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity(), RequestCallBack {
    override fun onSuccess(obj: Any) {
        offersFragment.startRequestView(obj as StartLinks)
        leadsFragment.startRequestView(obj as StartLinks)
        Singleton.mainLinks = obj as StartLinks
    }

    override fun onFail() {

    }

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

        WebClient.requestInitial(this, "https://testemobile.getninjas.com.br/")

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPageAdapter(supportFragmentManager)
        adapter.addFragment(offersFragment, "DISPONIVEL")
        adapter.addFragment(leadsFragment, "Aceitos")
        viewPager.adapter = adapter
        //tabs.getTabAt(0)!!.setIcon(R.drawable.ic_check)
        //tabs.getTabAt(1)!!.setIcon(R.drawable.ic_check)
    }

    override fun onRestart() {
        super.onRestart()
        WebClient.requestInitial(this, "https://testemobile.getninjas.com.br/")
    }

    override fun onResume() {
        super.onResume()
        WebClient.requestInitial(this, "https://testemobile.getninjas.com.br/")
    }

}
