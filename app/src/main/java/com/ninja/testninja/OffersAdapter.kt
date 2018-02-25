package com.ninja.testninja

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.custom_cell.view.*

//CREATOFFERS
class OffersAdapter(val creatOffers: CreatOffers): RecyclerView.Adapter<CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.custom_cell,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return creatOffers.offers.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val test = creatOffers.offers.get(position)

        holder?.view?.textView_title?.text= test._embedded.request.title
        holder?.view?.textView_name?.text= test._embedded.request._embedded.user.name
        holder?.view?.textView_lugar?.text= test._embedded.request._embedded.address.neighborhood +
                " - " +test._embedded.request._embedded.address.city
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view)
