package com.com.contact.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.com.contact.R
import com.com.contact.model.Person
import com.com.contact.view.DetailActivity
import com.com.contact.viewholder.ContactViewHolder

/**
 * Created by Muhammad Al Faisal on 1/23/21.
 */
class ContactAdapter(private var person: List<Person>) :
    RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact_phone, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.onBindView(person[position])
    }

    override fun getItemCount() = if (person.isEmpty()) 0 else person.size
}