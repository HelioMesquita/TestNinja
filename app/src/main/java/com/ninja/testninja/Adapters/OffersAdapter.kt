package com.ninja.testninja.Adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Others.CreatOffers
import com.ninja.testninja.Activitys.NextOfferActivity
import com.ninja.testninja.R
import com.ninja.testninja.Others.Singleton
import kotlinx.android.synthetic.main.custom_cell_main.view.*

class OffersAdapter(val creatOffers: CreatOffers): RecyclerView.Adapter<CustomViewHolderOffers>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderOffers {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.custom_cell_main,parent,false)
        return CustomViewHolderOffers(cellForRow)
    }

    override fun getItemCount(): Int {
        return creatOffers.offers.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolderOffers?, position: Int) {
        val test = creatOffers.offers.get(position)

        holder?.view?.textView_title?.text= test._embedded.request.title
        holder?.view?.textView_name?.text= test._embedded.request._embedded.user.name
        holder?.view?.textView_lugar?.text= test._embedded.request._embedded.address.neighborhood +
                " - " +test._embedded.request._embedded.address.city
        if(test.state == "unread"){
            holder?.view?.imageViewPessoa?.setImageResource(R.drawable.iconipessoacinza)
            holder?.view?.imageViewLocal?.setImageResource(R.drawable.iconilugarcinza)
        }





    }

}

class CustomViewHolderOffers(val view: View): RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            nextView()
        }
    }

    fun nextView(){
        //WebClient().responseNextOffers(Singleton.offers.offers[valor]._links.self.href)
        val intet = Intent(view.context, NextOfferActivity::class.java)
        Singleton.offersNext = Singleton.offers.offers[adapterPosition]
        view.context.startActivity(intet)
    }
}
