package com.cervezoteca.anjov.cervezotecakotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_item.view.*

/**
 * Created by anjov on 09/04/2017.
 */
class ItemAdapter(val items: List<Item>, val listener:(Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    //Funciones de extension como funciones extension como parametros
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.itemView) {
        val item = items[position]
        item_title.text = item.title
        item_image.loadUrl(item.url)
        setOnClickListener { listener(item) }
    }


    override fun getItemCount() = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_item))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}