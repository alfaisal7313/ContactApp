package com.com.contact.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.com.contact.R
import com.com.contact.model.Person

class DetailActivity : AppCompatActivity() {
    private var name: TextView? = null
    private var phone: TextView? = null
    private var relation: TextView? = null
    private var email: TextView? = null
    private var imageView: ImageView? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_activity)

        name = findViewById(R.id.nameText)
        phone = findViewById(R.id.phoneText)
        relation = findViewById(R.id.relationText)
        email = findViewById(R.id.eamilText)
        imageView = findViewById(R.id.avatarImage)

        val intentData = intent.getParcelableExtra<Person>("data_contact")
        
        name?.text = if (!intentData?.name.isNullOrBlank()) intentData?.name.toString()else "-"
        phone?.text = if (!intentData?.phone.isNullOrBlank()) intentData?.phone.toString()else "-"
        relation?.text = if (!intentData?.relation.isNullOrBlank()) intentData?.relation.toString()else "-"
        email?.text = if (!intentData?.email.isNullOrBlank()) intentData?.email.toString() else "-"

        Glide.with(this)
            .load(intentData?.image)
            .error(R.drawable.cicle_placeholder)
            .placeholder(R.drawable.cicle_placeholder)
            .into(imageView!!)
    }
}