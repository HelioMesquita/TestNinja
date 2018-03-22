package com.ninja.testninja.Adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninja.testninja.Activitys.NextLeadsActivity
import com.ninja.testninja.Others.CreatLeads
import com.ninja.testninja.Others.Singleton
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

    override fun onBindViewHolder(holder: CustomViewHolderLeads?, position: Int) {
        val textLeads = creatLeads.leads[position]

        holder?.view?.textView_title?.text = textLeads.title()
        holder?.view?.textView_name?.text = textLeads.name()
        holder?.view?.textView_lugar?.text = textLeads.place()
        holder?.view?.textViewDate?.text = textLeads.data()

    }

}

class CustomViewHolderLeads(val view: View): RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            nextView()
        }
    }

    fun nextView(){
        Singleton.leadsNextLinks = Singleton.leads.leads[adapterPosition].links.self.href
        view.context.startActivity(Intent(view.context, NextLeadsActivity::class.java))
    }

}

