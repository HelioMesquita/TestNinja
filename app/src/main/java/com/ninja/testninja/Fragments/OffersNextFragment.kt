package com.ninja.testninja.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.ninja.testninja.Activitys.NextOfferActivity
import com.ninja.testninja.Others.OffersNext
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.Others.WebClient

import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_offers_next.*
import kotlinx.android.synthetic.main.fragment_offers_next.view.*


class OffersNextFragment : Fragment(), OnMapReadyCallback {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_offers_next, container, false)

        val implementAll = implementAll(view)

        WebClient().responseNextOffers(Singleton.offersNext._links.self.href,
                view.recyclerView,view.context,NextOfferActivity(),implementAll)
        //MANDAR OS PARAMETROS DA TELA DO FRAGMET





        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(mapView!=null){
            //mapView.onCreate(null)
            //mapView.onResume()
            mapView.getMapAsync(this)
        }

    }




    class implementAll(val view: View){
        fun implement(offersNext: OffersNext){
            view.textViewTitleFragmet.text=offersNext.title
            view.textViewClient.text=Singleton.offersNext._embedded.request._embedded.user.name
            view.textViewLocal.text=Singleton.offersNext._embedded.request._embedded.address.neighborhood +
                    " - " +Singleton.offersNext._embedded.request._embedded.address.city

            view.textViewEmail.text=offersNext._embedded.user.email
            view.textViewDistance.text=offersNext.distance


            var phone = offersNext._embedded.user._embedded.phones[0].number.toString()
            phone=phone.replace("[","")
            phone=phone.replace("]","")
            view.textViewNumber.text=phone


            //view.textViewNumber.text=offersNext._embedded.user._embedded
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        val mMap = googleMap
        //MapsInitializer.initialize(view?.context)
        //googleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
    }
}

