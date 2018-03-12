package com.ninja.testninja.Adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Others.OffersNext
import com.ninja.testninja.R


class OffersNextAdapter(val OffersNext: OffersNext): RecyclerView.Adapter<CustomViewHolderNextOffers>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderNextOffers {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.custom_cell_next_offer,parent,false)
        return CustomViewHolderNextOffers(cellForRow)
    }

    override fun getItemCount(): Int {
        return OffersNext._embedded.info.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolderNextOffers?, position: Int) {
        val test = OffersNext._embedded.info.get(position)


    }

}

class CustomViewHolderNextOffers(val view: View): RecyclerView.ViewHolder(view){

}