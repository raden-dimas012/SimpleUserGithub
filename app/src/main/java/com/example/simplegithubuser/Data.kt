package com.example.simplegithubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val avatar: Int?= null,
    val nama: String?= null,
    val userName: String?= null,
    val location: String?= null,
    val repository: String?= null,
    val company: String?= null,
    val followers: String?= null,
    val following: String? = null
) : Parcelable
