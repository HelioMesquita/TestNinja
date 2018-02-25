package com.ninja.testninja


import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_offers.*
import kotlinx.android.synthetic.main.fragment_offers.view.*


class OffersFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_offers, container, false)


        WebClient().requestInicial("https://testemobile.getninjas.com.br/",
                view.RecyclerViewOffers,view.context, MainActivity())

        view.RecyclerViewOffers

        return view
    }

}
