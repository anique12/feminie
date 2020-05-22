package com.example.handyman.Models.jobSeeker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Seekers(
    val general_information: GeneralInformation,
    val hourly_rate: Int,
    val id: Int,
    val main_service: MainService,
    val sub_service: List<SubService>
):Parcelable