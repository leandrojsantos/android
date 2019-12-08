package com.univem.firstapplication.data.local

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Thiago Corredo
 * @since 2019-11-17
 */
@Parcelize
data class Owner(
    @field:Json(name = "login") val login: String,
    @field:Json(name = "avatar_url") val avatarUrl: String
) : Parcelable
