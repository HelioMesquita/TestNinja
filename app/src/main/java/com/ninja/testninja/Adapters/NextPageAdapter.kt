package com.ninja.testninja.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Others.Factory
import com.ninja.testninja.Others.PageNext
import kotlinx.android.synthetic.main.custom_cell_next_offer.view.*



class NextPageAdapter(val PageNext: PageNext,val layout:Int): RecyclerView.Adapter<CustomViewHolderNextPage>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderNextPage {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(layout,parent,false)
        return CustomViewHolderNextPage(cellForRow)
    }

    override fun getItemCount(): Int {
        return PageNext._embedded.info.size
    }

    override fun onBindViewHolder(holder: CustomViewHolderNextPage?, position: Int) {
        val textNext = Factory.creatNextText(PageNext._embedded.info.get(position))

        holder?.view?.textViewTitulo?.text=textNext.title
        holder?.view?.textViewValue?.text=textNext.value

    }

}

class CustomViewHolderNextPage(val view: View): RecyclerView.ViewHolder(view){}