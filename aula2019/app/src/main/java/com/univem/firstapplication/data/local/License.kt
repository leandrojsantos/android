package com.univem.firstapplication.data.local

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */
@Parcelize
data class License(
    @field:Json(name = "name") val name: String
) : Parcelable