package com.univem.firstapplication.ui.gist

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.univem.firstapplication.R
import kotlinx.android.synthetic.main.fragment_gist.*
import kotlinx.android.synthetic.main.list_indicators.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GistFragment : Fragment(R.layout.fragment_gist) {

    private var adapter = GistAdapter()
    private val gistViewModel: GistViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gistRecyclerView.adapter = adapter
        gistRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        gistViewModel.viewState.observe(this, Observer<GistViewState> {
            when (it) {
                is GistViewState.Items -> {
                    loadingProgress.visibility = GONE
                    adapter.submitList(it.repositories)
                }
                is GistViewState.EmptyState -> {
                    loadingProgress.visibility = GONE
                    infoLayout.visibility = VISIBLE
                    infoIcon.setImageResource(R.drawable.ic_format_list_numbered_gray_72dp)
                    infoText.setText(R.string.empty_list_gist)
                }
                is GistViewState.ShowError -> {
                    loadingProgress.visibility = GONE
                    infoLayout.visibility = VISIBLE
                    infoIcon.setImageResource(it.imageId)
                    infoText.setText(it.messageId)
                }
            }
        })
        gistViewModel.getGists()
    }

    companion object {
        fun newInstance() = GistFragment()
    }
}