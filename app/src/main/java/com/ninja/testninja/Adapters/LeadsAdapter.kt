package com.ninja.testninja.Adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Others.CreatLeads
import com.ninja.testninja.R
import kotlinx.android.synthetic.main.custom_cell_leads.view.*

class LeadsAdapter(val creatLeads: CreatLeads): RecyclerView.Adapter<CustomViewHolderLeads>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolderLeads {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.custom_cell_leads,parent,false)
        return CustomViewHolderLeads(cellForRow)
    }

    override fun getItemCount(): Int {
        return creatLeads.leads.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolderLeads?, position: Int) {
        val test = creatLeads.leads.get(position)

        holder?.view?.textView_title?.text=test._embedded.request.title
        holder?.view?.textView_name?.text=test._embedded.user.name
        holder?.view?.textView_lugar?.text=test._embedded.address.neighborhood + " - " +
                test._embedded.address.city

    }

}

class CustomViewHolderLeads(val view: View): RecyclerView.ViewHolder(view){


}