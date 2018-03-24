package com.ninja.testninja.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Adapters.OffersAdapter
import com.ninja.testninja.Interfaces.RequestCallBack
import com.ninja.testninja.Interfaces.StarView
import com.ninja.testninja.DataClass.OffersList
import com.ninja.testninja.DataClass.StartLinks
import com.ninja.testninja.Others.WebClient
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_offers.view.*

class OffersFragment : Fragment(), StarView, RequestCallBack, SwipeRefreshLayout.OnRefreshListener {

    lateinit var offersList: OffersList

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_offers, container, false)

        configRefresh(view)

        return view
    }

    override fun configRefresh(view: View) {
        view.swipeOffers!!.setOnRefreshListener(this)
        view.swipeOffers!!.setColorSchemeResources(R.color.colorBlueGet)
    }

    override fun isRefreshing() {
        if (view?.swipeOffers!!.isRefreshing && view?.swipeOffers!=null){
            view?.swipeOffers!!.isRefreshing = false
        }
    }

    override fun onRefresh() {
        WebClient.responseOffersRefresh(offersList.linksOffer(), this)
    }

    override fun onSuccess(obj: Any) {
        popularRecyclerView(obj)
        isRefreshing()
        offersList = obj as OffersList
    }

    override fun onFail() {

    }

    override fun popularRecyclerView(obj: Any) {
        activity.runOnUiThread {
            view!!.RecyclerViewOffers.layoutManager = LinearLayoutManager(context)
            view!!.RecyclerViewOffers.adapter = OffersAdapter(obj as OffersList)
        }
    }

    override fun performRequest(startLinks: StartLinks) {
        WebClient.responseOffers(startLinks.linkOffer(), this)
    }
}
