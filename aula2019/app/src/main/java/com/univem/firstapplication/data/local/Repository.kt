package com.univem.firstapplication.data.local

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Thiago Corredo
 * @since 2019-11-17
 */
@Parcelize
data class Repository(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "full_name") val fullName: String,
    @field:Json(name = "owner") val owner: Owner,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "forks") val forks: Int,
    @field:Json(name = "stargazers_count") val starCount: Int,
    @field:Json(name = "license") val license: License?
) : Parcelable {
    companion object {
        val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
                return oldItem == newItem
            }
        }
    }
}
