package com.univem.firstapplication.data.local

import com.squareup.moshi.Json

/**
 * @author Thiago Corredo
 * @since 2019-11-17
 */

data class ItemsResponse<T>(@field:Json(name = "items") val response: List<T>)