package com.ninja.testninja.Adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.DataClass.OffersList
import com.ninja.testninja.Activitys.OfferDeteilActivity
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.custom_cell_offer.view.*

class OffersAdapter(val offersList: OffersList): RecyclerView.Adapter<CustomViewHolderOffers>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderOffers {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.custom_cell_offer,parent,false)
        return CustomViewHolderOffers(cellForRow,offersList)
    }

    override fun getItemCount(): Int {
        return offersList.offers.size
    }

    override fun onBindViewHolder(holder: CustomViewHolderOffers?, position: Int) {
        val offers = offersList.offers.get(position)

        holder?.view?.textView_title?.text = offers.title()
        holder?.view?.textView_name?.text = offers.name()
        holder?.view?.textView_lugar?.text = offers.place()
        if (offers.state() == "unread") {
            holder?.view?.imageViewPessoa?.setImageResource(R.drawable.iconipessoacinza)
            holder?.view?.imageViewLocal?.setImageResource(R.drawable.ic_location)
        }

        holder?.view?.textViewDate?.text = offers.data()
    }
}

class CustomViewHolderOffers(val view: View,val offersList: OffersList): RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            nextView()
        }
    }

    fun nextView(){
        view.context.startActivity(Intent(view.context, OfferDeteilActivity::class.java)
                .putExtra("link",offersList.offers[adapterPosition].link()))
    }
}
