package com.example.handyman.Models.jobSeeker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubService(
    val id: Int,
    val service: Service,
    val service_img: String,
    val title: String
):Parcelable