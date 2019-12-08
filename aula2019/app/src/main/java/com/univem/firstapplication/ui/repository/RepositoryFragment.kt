package com.univem.firstapplication.ui.repository

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.univem.firstapplication.R
import com.univem.firstapplication.util.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_repository.*
import kotlinx.android.synthetic.main.list_indicators.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepositoryFragment : Fragment(R.layout.fragment_repository) {

    private var adapter = RepositoryAdapter()
    private val repositoryViewModel: RepositoryViewModel by viewModel()
    private lateinit var scrollListener: EndlessRecyclerViewScrollListener
    private var isLoading: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        repositoryRecyclerView.adapter = adapter
        repositoryRecyclerView.layoutManager = linearLayoutManager

        repositoryViewModel.viewState.observe(this, Observer<RepositoryViewState> {
            when (it) {
                is RepositoryViewState.Items -> {
                    loadingProgress.visibility = GONE
                    adapter.submitList(it.repositories)
                    isLoading = false
                }
                is RepositoryViewState.EmptyState -> {
                    loadingProgress.visibility = GONE
                    infoLayout.visibility = VISIBLE
                    infoIcon.setImageResource(R.drawable.ic_format_list_numbered_gray_72dp)
                    infoText.setText(R.string.empty_list_repository)
                    isLoading = false
                }
                is RepositoryViewState.ShowError -> {
                    loadingProgress.visibility = GONE
                    infoLayout.visibility = VISIBLE
                    infoIcon.setImageResource(it.imageId)
                    infoText.setText(it.messageId)
                    isLoading = false
                }
            }
        })
        scrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                repositoryViewModel.getRepositories()
            }
        }
        repositoryRecyclerView.addOnScrollListener(scrollListener)
        repositoryViewModel.getRepositories()
    }

    companion object {
        fun newInstance() = RepositoryFragment()
    }
}