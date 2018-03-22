package com.ninja.testninja.Fragments


import android.annotation.SuppressLint
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
import com.ninja.testninja.Others.PageNext
import com.ninja.testninja.Others.Singleton
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.fragment_offers_next.*
import kotlinx.android.synthetic.main.fragment_offers_next.view.*


class OffersNextFragment : Fragment(), OnMapReadyCallback, PresentationFragment {
    lateinit var mMap:GoogleMap
    override fun popularFragment(obj: Any) {
        if(activity !=null) {
            implement(obj as PageNext)
            popularRecyclerView(obj)
            logalMap(obj as PageNext)
        }
    }

    override fun popularRecyclerView(obj: Any) {
        Singleton.offersNextLinks = obj as PageNext
        activity.runOnUiThread {
            view!!.recyclerView.layoutManager = LinearLayoutManager(context)
            view!!.recyclerView.recyclerView.adapter =
                    NextPageAdapter(obj as PageNext,R.layout.custom_cell_next_offer)
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
            mapView.onCreate(null)
            mapView.onResume()
            mapView.getMapAsync(this)
        }

    }

    @SuppressLint("SetTextI18n")
    override fun implement(obj: PageNext) {
        activity.runOnUiThread {
            view!!.textViewTitleFragmet.text = obj.title
            view!!.textViewClient.text = obj._embedded.user.name
            view!!.textViewLocal.text = obj._embedded.address.neighborhood +
                    obj._embedded.address.city

            view!!.textViewEmail.text = obj._embedded.user.email

            val dist = (obj.distance.toInt())/1000

            view!!.textViewDistance.text = "a $dist km de voce"

            var phone = obj._embedded.user._embedded.phones[0].number.toString()
            phone = phone.replace("[", "")
            phone = phone.replace("]", "")
            view!!.textViewNumber.text = phone
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        MapsInitializer.initialize(view?.context)
        googleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL

        /**
        val cam = CameraPosition.builder()
                .target(LatLng(obj._embedded.address.geolocation.latitude
                        ,obj._embedded.address.geolocation.longitude))
                .zoom(16F).bearing(0F).tilt(45F).build()

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cam))
        **/
    }


    fun logalMap(obj: PageNext){
        //mMap.addCircle(MarkerOptions().position(LatLng(obj._embedded.address.geolocation.latitude,obj._embedded.address.geolocation.longitude)))
        Thread{
            if(obj!=null){
                activity.runOnUiThread {
                    val cam = CameraPosition.builder()
                            .target(LatLng(obj._embedded.address.geolocation.latitude
                                    ,obj._embedded.address.geolocation.longitude))
                            .zoom(16F).bearing(0F).build()

                    mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cam))


                    mMap.addCircle(CircleOptions().center(LatLng(obj._embedded.address.geolocation.latitude
                            ,obj._embedded.address.geolocation.longitude)).radius(150.0).fillColor(0xA3D4E4).strokeColor(Color.BLUE))
                            //MarkerOptions().position(LatLng(obj._embedded.address.geolocation.latitude,obj._embedded.address.geolocation.longitude)))
                }
            }else{
                logalMap(obj)
            }
        }.start()


    }
}

