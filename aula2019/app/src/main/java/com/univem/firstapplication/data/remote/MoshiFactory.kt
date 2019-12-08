package com.univem.firstapplication.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import java.util.*


/**
 * @author Thiago Corredo
 * @since 2019-11-22
 */
class MoshiFactory {

    init {
        throw RuntimeException("No instances!")
    }

    companion object {

        private val MOSHI =
            Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                .build()

        fun get(): Moshi {
            return MOSHI
        }
    }
}