package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.pacheco.purrfectbreeds.HiltApplication
import com.pacheco.purrfectbreeds.R
import com.pacheco.purrfectbreeds.ui.component.Body
import com.pacheco.purrfectbreeds.ui.component.FavoriteButton
import com.pacheco.purrfectbreeds.ui.component.Headline
import com.pacheco.purrfectbreeds.ui.component.SearchIcon
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.pacheco.purrfectbreeds.ui.res.HomeLabel
import com.pacheco.purrfectbreeds.ui.viewmodel.BaseViewModel
import com.pacheco.purrfectbreeds.ui.viewmodel.HomeViewModel
import com.purrfectbreeds.model.BreedModel

@Composable
fun HomeView(
    viewModel: BaseViewModel<HomeEvent, PagingData<BreedModel>> = hiltViewModel<HomeViewModel>(),
    navigateToFavorites: () -> Unit
) {
    val state = viewModel.state.collectAsLazyPagingItems()
    HomeLayout(state = state, onEvent = viewModel::onEvent, navigateToFavorites = navigateToFavorites)
    HiltApplication.loadState = state.loadState.refresh
}

@Composable
private fun HomeLayout(
    state: LazyPagingItems<BreedModel>,
    onEvent: (HomeEvent) -> Unit,
    navigateToFavorites: () -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Headline(text = HomeLabel.HEADLINE, modifier = Modifier.weight(weight = 1f))
            FavoriteButton(onClick = {
                navigateToFavorites()
                onEvent(HomeEvent.ResetSearch)
            })
        }
        SearchBar(onEvent = onEvent)
        BreedsGrid(state = state, onEvent = onEvent)
    }
}

@Composable
private fun BreedsGrid(
    state: LazyPagingItems<BreedModel>,
    onEvent: (HomeEvent) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(count = 2),
        modifier = Modifier.padding(top = 20.dp)
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

            Box(contentAlignment = Alignment.TopEnd) {
                FavoriteButton(isFavorite = state[it]!!.isFavorite) {
                    onEvent(HomeEvent.ChangeFavorite(id = state[it]!!.id))
                }
            }
        }
    }
}

@Composable
private fun SearchBar(onEvent: (HomeEvent) -> Unit) {
    val input = remember { mutableStateOf(String()) }

    OutlinedTextField(
        value = input.value,
        onValueChange = {
            input.value = it
            onEvent(HomeEvent.Search(name = it))
        },
        textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onSurface),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            SearchIcon()
        },
        label = {
            Body(text = HomeLabel.SEARCH_BAR_HINT)
        }
    )
}