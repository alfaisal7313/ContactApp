package com.com.contact.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.com.contact.R
import com.com.contact.adapter.ContactAdapter
import com.com.contact.model.Person
import com.com.contact.model.PersonData
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private var rvContactList: RecyclerView? = null
    private var contactAdapter: ContactAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContactList = findViewById(R.id.rv_contact)

        rvContactList?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        assets.open("person.json")
            .bufferedReader()
            .use {
                val personData= Gson().fromJson(it.readText(), PersonData::class.java)
                if (personData.success){
                    contactAdapter = ContactAdapter(personData.data)
                    rvContactList?.adapter = contactAdapter
                }else Toast.makeText(this, "Data is Empty", Toast.LENGTH_LONG).show()
            }
    }
}