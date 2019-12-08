package com.univem.firstapplication.data.local

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * @author Thiago Corredo
 * @since 2019-11-22
 */
@Parcelize
data class Gist(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "created_at") val createAt: Date,
    @field:Json(name = "updated_at") val updateAt: Date,
    @field:Json(name = "html_url") val htmlUrl: String,
    @field:Json(name = "files") val files: Map<String, GistFile>,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "comments") val comments: Int,
    @field:Json(name = "owner") val owner: Owner
) : Parcelable {
    companion object {
        val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Gist>() {
            override fun areItemsTheSame(oldItem: Gist, newItem: Gist): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Gist, newItem: Gist): Boolean {
                return oldItem == newItem
            }
        }
    }
}