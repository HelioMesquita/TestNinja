package com.ninja.testninja.Adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Others.CreatOffers
import com.ninja.testninja.Activitys.NextOfferActivity
import com.ninja.testninja.Others.Factory
import com.ninja.testninja.R
import com.ninja.testninja.Others.Singleton
import kotlinx.android.synthetic.main.custom_cell_offer.view.*

class OffersAdapter(val creatOffers: CreatOffers): RecyclerView.Adapter<CustomViewHolderOffers>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderOffers {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.custom_cell_offer,parent,false)
        return CustomViewHolderOffers(cellForRow)
    }

    override fun getItemCount(): Int {
        return creatOffers.offers.size
    }

    override fun onBindViewHolder(holder: CustomViewHolderOffers?, position: Int) {
        val offers = creatOffers.offers.get(position)

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

class CustomViewHolderOffers(val view: View): RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            nextView()
        }
    }

    fun nextView(){
        Singleton.offersNext = Singleton.offers.offers[adapterPosition]
        view.context.startActivity(Intent(view.context, NextOfferActivity::class.java))
    }
}
