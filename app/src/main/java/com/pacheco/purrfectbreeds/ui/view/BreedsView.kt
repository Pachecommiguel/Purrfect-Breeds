package com.pacheco.purrfectbreeds.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.pacheco.purrfectbreeds.HiltApplication
import com.pacheco.purrfectbreeds.ui.component.*
import com.pacheco.purrfectbreeds.ui.event.BreedsEvent
import com.pacheco.purrfectbreeds.ui.res.HomeLabel
import com.pacheco.purrfectbreeds.ui.viewmodel.BaseViewModel
import com.pacheco.purrfectbreeds.ui.viewmodel.BreedsViewModel
import com.purrfectbreeds.model.BreedModel

@Composable
fun BreedsView(
    viewModel: BaseViewModel<BreedsEvent, PagingData<BreedModel>> = hiltViewModel<BreedsViewModel>(),
    navigateToDetails: (String) -> Unit
) {
    val state = viewModel.stateResult.collectAsLazyPagingItems()

    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        viewModel.onEvent(event = BreedsEvent.Refresh)
    }

    when(state.loadState.refresh) {
        LoadState.Loading -> {}
        is LoadState.Error -> EmptyLayout(headline = HomeLabel.HEADLINE, body = HomeLabel.EMPTY_BODY)
        is LoadState.NotLoading -> HomeLayout(
            state = state,
            onEvent = viewModel::onEvent,
            navigateToDetails = navigateToDetails
        )
    }

    HiltApplication.loadState = state.loadState.refresh
}

@Composable
private fun HomeLayout(
    state: LazyPagingItems<BreedModel>,
    onEvent: (BreedsEvent) -> Unit,
    navigateToDetails: (String) -> Unit
) {
    Column {
        Headline(text = HomeLabel.HEADLINE)
        SearchBar(onEvent = onEvent)
        BreedsGrid(
            pagingItems = state,
            onFavoriteClick = { onEvent(BreedsEvent.ChangeFavorite(id = it)) },
            onClick = navigateToDetails
        )
    }
}

@Composable
private fun SearchBar(onEvent: (BreedsEvent) -> Unit) {
    val input = remember {
        mutableStateOf(String())
    }

    OutlinedTextField(
        value = input.value,
        onValueChange = {
            input.value = it
            onEvent(BreedsEvent.Search(name = it))
        },
        textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onSurface),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = { SearchIcon() },
        label = { Body(text = HomeLabel.SEARCH_BAR_HINT) }
    )
}