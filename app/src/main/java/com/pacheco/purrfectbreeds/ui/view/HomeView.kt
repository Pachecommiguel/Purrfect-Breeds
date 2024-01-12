package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.pacheco.purrfectbreeds.ui.viewmodel.BaseViewModel
import com.pacheco.purrfectbreeds.ui.viewmodel.HomeViewModel
import com.purrfectbreeds.model.ImageModel

@Composable
fun HomeView(
    viewModel: BaseViewModel<HomeEvent, PagingData<ImageModel>> = hiltViewModel<HomeViewModel>(),
) {
    val state = viewModel.state.collectAsLazyPagingItems()
    HomeLayout(state = state)
}

@Composable
private fun HomeLayout(state: LazyPagingItems<ImageModel>) {
    LazyColumn {
        items(state.itemCount) {
            Text(text = state[it]!!.id)
        }

        when(state.loadState.refresh) {
            LoadState.Loading -> {}
            is LoadState.Error -> {}
            is LoadState.NotLoading -> {}
        }
    }
}