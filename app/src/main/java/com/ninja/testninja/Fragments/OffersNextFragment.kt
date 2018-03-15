package com.ninja.testninja.Fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.ninja.testninja.Adapters.OffersNextAdapter
import com.ninja.testninja.Interfaces.FragmentsPopular
import com.ninja.testninja.Others.OffersNext
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_offers_next.*
import kotlinx.android.synthetic.main.fragment_offers_next.view.*


class OffersNextFragment : Fragment(), OnMapReadyCallback, FragmentsPopular {
    override fun popularFragment(obj: Any) {
        implement(obj as OffersNext)
        popularRecyclerView(obj)
    }

    override fun popularRecyclerView(obj: Any) {
        activity.runOnUiThread {
            view!!.recyclerView.layoutManager = LinearLayoutManager(context)
            view!!.recyclerView.recyclerView.adapter = OffersNextAdapter(obj as OffersNext)
        }
    }



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_offers_next, container, false)

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

    @SuppressLint("SetTextI18n")
    fun implement(offersNext: OffersNext) {
        activity.runOnUiThread {
            view!!.textViewTitleFragmet.text = offersNext.title
            view!!.textViewClient.text = offersNext._embedded.user.name

            view!!.textViewLocal.text = Singleton.offersNext._embedded.request._embedded.address.neighborhood +
                    " - " + Singleton.offersNext._embedded.request._embedded.address.city

            view!!.textViewEmail.text = offersNext._embedded.user.email

            var a = offersNext.distance
            a = a[0].toString() + a[1].toString()

            view!!.textViewDistance.text = "a $a km de voce"

            var phone = offersNext._embedded.user._embedded.phones[0].number.toString()
            phone = phone.replace("[", "")
            phone = phone.replace("]", "")
            view!!.textViewNumber.text = phone
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        val mMap = googleMap
        //MapsInitializer.initialize(view?.context)
        //googleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
    }
}

