package com.com.contact.viewholder

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.com.contact.R
import com.com.contact.model.Person
import com.com.contact.view.DetailActivity

/**
 * Created by Muhammad Al Faisal on 1/23/21.
 */
class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imgPerson = itemView.findViewById<ImageView>(R.id.item_contact_image)
    private val namePerson = itemView.findViewById<TextView>(R.id.item_contact_name)
    private val phonePerson = itemView.findViewById<TextView>(R.id.item_contact_phone)
    private val relationPerson = itemView.findViewById<TextView>(R.id.item_contact_relation)
    private val emailPerson = itemView.findViewById<TextView>(R.id.item_contact_email)

    fun onBindView(person: Person) {
        namePerson.text = if (!person.name.isNullOrBlank()) person.name else "-"
        phonePerson.text = if (!person.phone.isNullOrBlank()) person.phone else "-"
        relationPerson.text =  if (!person.relation.isNullOrBlank())person.relation else "-"
        emailPerson.text = if (!person.email.isNullOrBlank()) person.email else "-"

        Log.d("TAG", "onBindViewMessage: ${person.image}")
        Glide.with(itemView.context)
            .load(person.image)
            .circleCrop()
            .error(R.drawable.cicle_placeholder)
            .placeholder(R.drawable.cicle_placeholder)
            .into(imgPerson)

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("data_contact", person)
            itemView.context.startActivity(intent)
        }
    }
}