package com.univem.firstapplication.ui.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.univem.firstapplication.R
import com.univem.firstapplication.data.local.Repository
import com.univem.firstapplication.util.ImageUtils
import kotlinx.android.synthetic.main.item_list_repository.view.*


/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */

class RepositoryAdapter :
    ListAdapter<Repository, RepositoryAdapter.ViewHolder>(Repository.DIFF_UTIL_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_repository, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(repository: Repository) {
            itemView.repositoryTitle.text = repository.name
            itemView.repositoryForkNumber.text = repository.forks.toString()
            itemView.repositoryStarNumber.text = repository.starCount.toString()
            itemView.repositoryDescription.text = repository.description
            ImageUtils.createRoundImage(itemView.userProfileImage, repository.owner.avatarUrl)
            itemView.repositoryUserName.text = repository.owner.login
            if (repository.license == null) {
                itemView.repositoryLicense.setText(R.string.repository_without_license)
            } else {
                itemView.repositoryLicense.text = repository.license.name
            }
        }
    }
}