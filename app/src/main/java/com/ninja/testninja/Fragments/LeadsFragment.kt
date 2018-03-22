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
import com.ninja.testninja.Others.CreatLeads
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_leads.view.*


class LeadsFragment : Fragment(), StarView, RequestCallBack, SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        WebClient.responseLeadsRefresh(Singleton.leads, this)
    }

    override fun popularRecyclerView(obj: Any) {
        Singleton.leads = obj as CreatLeads

        activity.runOnUiThread {
            view!!.RecylerViewLeads.layoutManager = LinearLayoutManager(context)
            view!!.RecylerViewLeads.adapter = LeadsAdapter(obj as CreatLeads)
            if (view?.swipeLeads!!.isRefreshing && view?.swipeLeads!=null){
                view?.swipeLeads!!.isRefreshing = false
            }
        }

    }

    override fun onSuccess(obj: Any) {
        popularRecyclerView(obj)

    }

    override fun onFail() {

    }

    override fun startRequestView(obj: Any) {
        WebClient.responseLeads(obj as StartLinks, this)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_leads, container, false)

        view.swipeLeads.setOnRefreshListener(this)
        view.swipeLeads.setColorSchemeResources(R.color.colorBlueGet)


        return view
    }


}