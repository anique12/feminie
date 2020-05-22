package com.example.handyman.Models.jobSeeker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeneralInformation(
    val dob: String,
    val gender: Int,
    val is_account_active: Boolean,
    val name: String,
    val profile_image: String,
    val role: Int
):Parcelable