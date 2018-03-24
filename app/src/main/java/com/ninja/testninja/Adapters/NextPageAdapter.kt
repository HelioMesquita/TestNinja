package com.ninja.testninja.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.DataClass.Detail
import kotlinx.android.synthetic.main.custom_cell_detail_offer.view.*

class NextPageAdapter(val Detail: Detail, val layout:Int): RecyclerView.Adapter<CustomViewHolderNextPage>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderNextPage {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(layout,parent,false)
        return CustomViewHolderNextPage(cellForRow)
    }

    override fun getItemCount(): Int {
        return Detail.embedded.info.size
    }

    override fun onBindViewHolder(holder: CustomViewHolderNextPage?, position: Int) {
        val textNext = Detail.embedded.info.get(position)

        holder?.view?.textViewTitulo?.text = textNext.title()
        holder?.view?.textViewValue?.text = textNext.value()
    }
}

class CustomViewHolderNextPage(val view: View): RecyclerView.ViewHolder(view){}
