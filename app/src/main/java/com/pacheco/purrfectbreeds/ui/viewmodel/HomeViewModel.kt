package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pacheco.purrfectbreeds.HiltApplication
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.usecase.GetBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getBreedsUseCase: GetBreedsUseCase
) : ViewModel(), BaseViewModel<HomeEvent, PagingData<BreedModel>> {

    override val state = MutableStateFlow<PagingData<BreedModel>>(value = PagingData.empty())

    init {
        viewModelScope.launch(context = CoroutineExceptionHandler { _, exception ->
            HiltApplication.isLoading = false
        }) {
            getBreedsUseCase().cachedIn(scope = this).collect {
                state.value = it
                HiltApplication.isLoading = false
            }
        }
    }

    override fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.Search -> onSearchEvent(event = event)
        }
    }

    private fun onSearchEvent(event: HomeEvent.Search) {

    }
}