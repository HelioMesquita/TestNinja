package com.ninja.testninja.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Adapters.LeadsAdapter
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Interfaces.StarView
import com.ninja.testninja.DataClass.LeadsList
import com.ninja.testninja.DataClass.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_leads.view.*


class LeadsFragment : Fragment(), StarView, SwipeRefreshLayout.OnRefreshListener, RequestCallBack<LeadsList>{

    lateinit var leadsList: LeadsList

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_leads, container, false)

        configRefresh(view)

        return view
    }

    override fun configRefresh(view: View) {
        view.swipeLeads!!.setOnRefreshListener(this)
        view.swipeLeads!!.setColorSchemeResources(R.color.colorBlueGet)
    }

    override fun isRefreshing() {
        if (view?.swipeLeads!!.isRefreshing && view?.swipeLeads!=null){
            view?.swipeLeads!!.isRefreshing = false
        }
    }

    override fun onRefresh() {
        WebClient.allResponse(leadsList.linksLeads(), this)
    }

    override fun popularRecyclerView(obj: Any) {
        activity.runOnUiThread {
            view!!.RecylerViewLeads.layoutManager = LinearLayoutManager(context)
            view!!.RecylerViewLeads.adapter = LeadsAdapter(obj as LeadsList)
        }
    }

    override fun OnSuccess(obj: LeadsList) {
        leadsList = obj
        popularRecyclerView(obj)
        isRefreshing()
    }

    override fun onFail() {

    }

    override fun performRequest(startLinks: StartLinks) {
        WebClient.allResponse(startLinks.linkLeads(), this)
    }
}
