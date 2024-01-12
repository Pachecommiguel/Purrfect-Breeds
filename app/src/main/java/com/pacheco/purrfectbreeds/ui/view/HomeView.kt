package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.pacheco.purrfectbreeds.R
import com.pacheco.purrfectbreeds.ui.component.Body
import com.pacheco.purrfectbreeds.ui.component.Headline
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.pacheco.purrfectbreeds.ui.res.HomeLabel
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
    Column {
        Headline(text = HomeLabel.HEADLINE)
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(count = 2),
            modifier = Modifier.padding(top = 10.dp)
        ) {
            items(count = state.itemCount) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = state[it]!!.url,
                        contentDescription = null,
                        error = painterResource(id = R.drawable.ic_downloading),
                        placeholder = painterResource(id = R.drawable.ic_downloading)
                    )
                    Body(text = state[it]!!.name, modifier = Modifier.padding(vertical = 5.dp))
                }
            }

            when(state.loadState.refresh) {
                LoadState.Loading -> {}
                is LoadState.Error -> {}
                is LoadState.NotLoading -> {}
            }
        }
    }
}