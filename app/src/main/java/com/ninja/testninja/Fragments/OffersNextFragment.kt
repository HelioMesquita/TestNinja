package com.ninja.testninja.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Activitys.NextOfferActivity
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.WebClient

import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_offers_next.view.*


class OffersNextFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_offers_next, container, false)

        WebClient().responseNextOffers(Singleton.offersNext._links.self.href,
                view.recyclerView,view.context,NextOfferActivity())






        return view
    }




}// Required empty public constructor
