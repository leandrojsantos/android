package com.univem.firstapplication.ui.gist

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.univem.firstapplication.R
import com.univem.firstapplication.data.local.Gist
import com.univem.firstapplication.util.ImageUtils
import kotlinx.android.synthetic.main.item_list_gist.view.*
import java.util.*


/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */

class GistAdapter :
    ListAdapter<Gist, GistAdapter.ViewHolder>(Gist.DIFF_UTIL_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_gist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(gist: Gist) {
            ImageUtils.createRoundImage(itemView.userProfileImage, gist.owner.avatarUrl)
            itemView.gistUserName.text = gist.owner.login
            itemView.gistTitle.text = gist.files.keys.joinToString(separator = ", ")
            itemView.gistCreatedTime.text = DateUtils.getRelativeTimeSpanString(
                gist.createAt.time,
                Calendar.getInstance().timeInMillis, DateUtils.MINUTE_IN_MILLIS
            )
            itemView.gistFilesNumber.text = gist.files.size.toString()
            itemView.gistCommentsNumber.text = gist.comments.toString()
        }
    }
}