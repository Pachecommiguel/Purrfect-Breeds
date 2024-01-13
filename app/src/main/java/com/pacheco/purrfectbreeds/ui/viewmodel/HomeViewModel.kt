package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.usecase.GetBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getBreedsUseCase: GetBreedsUseCase
) : ViewModel(), BaseViewModel<HomeEvent, PagingData<BreedModel>> {

    override val state = MutableStateFlow<PagingData<BreedModel>>(value = PagingData.empty())
    private lateinit var data: PagingData<BreedModel>

    init {
        viewModelScope.launch {
            getBreedsUseCase().cachedIn(scope = this).collect {
                data = it
                state.value = it
            }
        }
    }

    override fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.Search -> onSearchEvent(event = event)
        }
    }

    private fun onSearchEvent(event: HomeEvent.Search) {
        state.value = data.filter {
            it.name.contains(other = event.name, ignoreCase = true)
        }
    }
}