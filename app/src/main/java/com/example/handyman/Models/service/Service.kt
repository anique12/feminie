package com.example.handyman.Models.service

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Service(
    val id: Int,
    val service_img: String,
    val title: String
):Parcelable