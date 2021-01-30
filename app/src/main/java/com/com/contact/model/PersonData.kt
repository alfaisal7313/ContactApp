package com.com.contact.model

import com.google.gson.annotations.SerializedName

data class PersonData(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("data")
    val data: List<Person>
)