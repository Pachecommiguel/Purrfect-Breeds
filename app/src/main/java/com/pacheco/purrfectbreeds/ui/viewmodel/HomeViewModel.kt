package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.usecase.ChangeFavoriteUseCase
import com.purrfectbreeds.usecase.GetBreedsUseCase
import com.purrfectbreeds.usecase.GetFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getBreedsUseCase: GetBreedsUseCase,
    getFavoritesUseCase: GetFavoritesUseCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase
) : ViewModel(), BaseViewModel<HomeEvent, PagingData<BreedModel>> {

    override val stateResult = MutableStateFlow<PagingData<BreedModel>>(value = PagingData.empty())
    private var favorites: List<BreedModel>? = null

    init {
        viewModelScope.launch {
            getBreedsUseCase().cachedIn(scope = this).collect {
                stateResult.value = it
            }
        }

        viewModelScope.launch {
            getFavoritesUseCase().collect { favorites ->
                this@HomeViewModel.favorites = favorites
                stateResult.value = stateResult.value.map { breed -> breed.copy(
                    isFavorite = this@HomeViewModel.favorites?.firstOrNull {
                        it.id == breed.id
                    }?.isFavorite ?: false
                ) }
            }
        }
    }

    override fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.Search -> onSearchEvent(event = event)
            is HomeEvent.ChangeFavorite -> onChangeFavoriteEvent(event = event)
            HomeEvent.ResetSearch -> onResetSearchEvent()
        }
    }

    private fun onResetSearchEvent() {
        favorites?.let {
            stateResult.value = PagingData.from(data = it)
        }
    }

    private fun onChangeFavoriteEvent(event: HomeEvent.ChangeFavorite) {
        viewModelScope.launch {
            changeFavoriteUseCase(id = event.id)
        }
    }

    private fun onSearchEvent(event: HomeEvent.Search) {
        favorites?.let { favorites ->
            stateResult.value = PagingData.from(data = favorites.filter {
                it.name.contains(other = event.name, ignoreCase = true)
            })
        }
    }
}