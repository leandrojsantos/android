package com.univem.firstapplication.ui.repository

import com.univem.firstapplication.R
import com.univem.firstapplication.data.interactor.GetRepositoryListInteractor
import com.univem.firstapplication.data.local.ItemsResponse
import com.univem.firstapplication.data.local.Repository
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import java.io.IOException

class RepositoryViewModelTest {

    @get:Rule
    val instantExecutionRule = InstantExecutionRule()

    lateinit var viewModel: RepositoryViewModel
    private val getRepositoryListInteractor: GetRepositoryListInteractor = mockk()

    @Before
    fun setup() {
        viewModel = RepositoryViewModel(getRepositoryListInteractor)
    }

    @Test
    fun givenEmptyList_whenGettingApiResult_shouldReturnEmptyState() {
        val itemsResponse = ItemsResponse<Repository>(emptyList())

        coEvery { getRepositoryListInteractor.execute() } returns Response.success(itemsResponse)

        viewModel.getRepositories()

        assertEquals(viewModel.viewState.value, RepositoryViewState.EmptyState)
    }

    @Test
    fun givenEmptyList_whenGettingApiResult_shouldReturnItemState() {
        val itemsResponse = ItemsResponse<Repository>(listOf(mockk()))

        coEvery { getRepositoryListInteractor.execute() } returns Response.success(itemsResponse)

        viewModel.getRepositories()

        assertEquals(viewModel.viewState.value, RepositoryViewState.Items(itemsResponse.response))
    }

    @Test
    fun givenEmptyList_whenGettingApiResult_shouldReturnNetworkErrorState() {
        coEvery { getRepositoryListInteractor.execute() } throws IOException("Timeout")

        viewModel.getRepositories()

        assertEquals(viewModel.viewState.value, RepositoryViewState.ShowError(
            R.drawable.ic_signal_wifi_off_gray_72dp,
            R.string.network_error))
    }
}