package com.ninja.testninja.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Activitys.MainActivity
import com.ninja.testninja.R
import com.ninja.testninja.Others.Singleton
import kotlinx.android.synthetic.main.fragment_leads.view.*


class LeadsFragment : Fragment(){



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_leads, container, false)



        Singleton.requistLeadsParameters(view.RecylerViewLeads,view.context, MainActivity())





        return view
    }




}