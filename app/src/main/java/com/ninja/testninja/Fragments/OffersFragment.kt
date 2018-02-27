package com.ninja.testninja.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Activitys.MainActivity
import com.ninja.testninja.R
import com.ninja.testninja.Others.WebClient
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
