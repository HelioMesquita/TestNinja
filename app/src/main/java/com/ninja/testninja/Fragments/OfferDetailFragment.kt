package com.ninja.testninja.Fragments

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.ninja.testninja.Adapters.NextPageAdapter
import com.ninja.testninja.Interfaces.PresentationFragment
import com.ninja.testninja.DataClass.Detail
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_offers_deteil.*
import kotlinx.android.synthetic.main.fragment_offers_deteil.view.*

class OfferDetailFragment : Fragment(), OnMapReadyCallback, PresentationFragment {

    lateinit var mMap: GoogleMap

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_offers_deteil, container, false)

        return view
    }

    override fun implementMap(obj: Detail) {
        Thread{
            if(obj!=null){
                activity.runOnUiThread {
                    moviMap(obj)
                }
            }else{
                implementMap(obj)
            }
        }.start()
    }

    override fun moviMap(obj: Detail) {
        activity.runOnUiThread {
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder()
                    .target(LatLng(obj.latitude(),obj.longitude()))
                    .zoom(16F).bearing(0F).build()))
            mMap.addCircle(CircleOptions().center(LatLng(obj.latitude(),obj.longitude()))
                    .radius(150.0).fillColor(0xA3D4E4).strokeColor(Color.BLUE))
        }
    }

    override fun popularFragment(obj: Any) {
        if(activity !=null) {
            implement(obj as Detail)
            popularRecyclerView(obj)
            implementMap(obj as Detail)
        }
    }

    override fun popularRecyclerView(obj: Any) {
        activity.runOnUiThread {
            view!!.recyclerView.layoutManager = LinearLayoutManager(context)
            view!!.recyclerView.recyclerView.adapter =
                    NextPageAdapter(obj as Detail,R.layout.custom_cell_detail_offer)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(mapView!=null){
            mapView.onCreate(null)
            mapView.onResume()
            mapView.getMapAsync(this)
        }
    }

    override fun implement(obj: Detail) {
        activity.runOnUiThread {
            view!!.textViewTitleFragmet.text = obj.title()
            view!!.textViewClient.text = obj.name()
            view!!.textViewLocal.text = obj.place()
            view!!.textViewEmail.text = obj.email()
            view!!.textViewDistance.text = obj.distance()
            view!!.textViewNumber.text = obj.number()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        MapsInitializer.initialize(view?.context)
        googleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
    }
}
