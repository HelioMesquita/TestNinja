package com.ninja.testninja.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Others.OffersNext
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.custom_cell_next_offer.view.*



class OffersNextAdapter(val OffersNext: OffersNext): RecyclerView.Adapter<CustomViewHolderNextOffers>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderNextOffers {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.custom_cell_next_offer,parent,false)
        return CustomViewHolderNextOffers(cellForRow)
    }

    override fun getItemCount(): Int {
        return OffersNext._embedded.info.size
    }

    override fun onBindViewHolder(holder: CustomViewHolderNextOffers?, position: Int) {
        val text = OffersNext._embedded.info.get(position)

        holder?.view?.textViewTitulo?.text=text.label

        var textString = text.value.toString()

        textString=textString.replace("[","")
        textString=textString.replace("]","")

        holder?.view?.textViewValue?.text=textString



    }

}

class CustomViewHolderNextOffers(val view: View): RecyclerView.ViewHolder(view){

}