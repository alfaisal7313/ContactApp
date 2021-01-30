package com.com.contact.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Muhammad Al Faisal on 1/23/21.
 */

@Parcelize
data class Person(

    @SerializedName("avatar")
    val image: String?,

    @SerializedName("fullname")
    val name: String?,

    @SerializedName("relation")
    val relation: String?,

    @SerializedName("email")
    val email: String?,

    @SerializedName("phone_number")
    val phone: String?
): Parcelable
