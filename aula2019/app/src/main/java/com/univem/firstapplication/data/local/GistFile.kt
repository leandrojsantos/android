package com.univem.firstapplication.data.local

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Thiago Corredo
 * @since 2019-11-22
 */
@Parcelize
data class GistFile(
    @field:Json(name = "filename") val fileName: String,
    @field:Json(name = "type") val type: String,
    @field:Json(name = "language") val language: String,
    @field:Json(name = "rawUrl") val rawUrl: String,
    @field:Json(name = "size") val size: Int
) : Parcelable