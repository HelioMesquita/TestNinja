package com.ninja.testninja.Activitys

import android.support.v7.app.AppCompatActivity

import android.support.v4.view.ViewPager
import android.os.Bundle
import com.ninja.testninja.Adapters.SectionsPageAdapter
import com.ninja.testninja.Fragments.LeadsFragment
import com.ninja.testninja.Fragments.OffersFragment
import com.ninja.testninja.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val a = SectionsPageAdapter(supportFragmentManager)

        setupViewPager(container)
        tabs.setupWithViewPager(container)


    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPageAdapter(supportFragmentManager)
        adapter.addFragment(OffersFragment(), "DISPONIVEL")
        adapter.addFragment(LeadsFragment(),"Aceitos")
        viewPager.adapter = adapter
    }



}