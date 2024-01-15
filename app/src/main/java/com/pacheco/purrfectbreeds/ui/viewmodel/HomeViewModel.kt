package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.usecase.ChangeFavoriteUseCase
import com.purrfectbreeds.usecase.GetBreedsUseCase
import com.purrfectbreeds.usecase.GetOfflineBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getBreedsUseCase: GetBreedsUseCase,
    getOfflineBreedsUseCase: GetOfflineBreedsUseCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase
) : ViewModel(), BaseViewModel<HomeEvent, PagingData<BreedModel>> {

    override val stateResult = MutableStateFlow<PagingData<BreedModel>>(value = PagingData.empty())
    private lateinit var data: PagingData<BreedModel>

    init {
        viewModelScope.launch {
            getBreedsUseCase().cachedIn(scope = this).collect {
                data = it
                stateResult.value = it
            }
        }

        viewModelScope.launch {
            getOfflineBreedsUseCase().collect { favorites ->
                stateResult.value = stateResult.value.map { breed -> breed.copy(
                    isFavorite = favorites?.firstOrNull { it.id == breed.id }?.isFavorite ?: false
                )}
            }
        }
    }

    override fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.Search -> onSearchEvent(event = event)
            is HomeEvent.ChangeFavorite -> onChangeFavoriteEvent(event = event)
        }
    }

    private fun onChangeFavoriteEvent(event: HomeEvent.ChangeFavorite) {
        viewModelScope.launch {
            changeFavoriteUseCase(id = event.id)
        }
    }

    private fun onSearchEvent(event: HomeEvent.Search) {
        stateResult.value = data.filter {
            it.name.contains(other = event.name, ignoreCase = true)
        }
    }
}