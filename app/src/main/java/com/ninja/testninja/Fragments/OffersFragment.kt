package com.ninja.testninja.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Adapters.OffersAdapter
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Interfaces.StarView
import com.ninja.testninja.Others.CreatOffers
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_offers.view.*


class OffersFragment : Fragment(), StarView, RequestCallBack, SwipeRefreshLayout.OnRefreshListener {
    override fun configRefresh() {
        view?.swipeOffers?.setOnRefreshListener(this)
        view?.swipeOffers?.setColorSchemeResources(R.color.colorBlueGet)
    }

    override fun testRefresh() {
        if (view?.swipeOffers!!.isRefreshing && view?.swipeOffers!=null){
            view?.swipeOffers!!.isRefreshing = false
        }
    }

    override fun onRefresh() {
        WebClient.responseOffersRefresh(Singleton.offers, this)
    }

    override fun onSuccess(obj: Any) {
        popularRecyclerView(obj)
    }

    override fun onFail() {

    }

    override fun popularRecyclerView(obj: Any) {
        Singleton.offers = obj as CreatOffers

        activity.runOnUiThread {
            view!!.RecyclerViewOffers.layoutManager = LinearLayoutManager(context)
            view!!.RecyclerViewOffers.adapter = OffersAdapter(obj as CreatOffers)
            testRefresh()
        }

    }

    override fun startRequestView(obj: Any) {
        WebClient.responseOffers(obj as StartLinks, this)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_offers, container, false)

        configRefresh()

        return view
    }

}
