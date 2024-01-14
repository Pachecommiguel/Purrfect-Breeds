package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pacheco.purrfectbreeds.ui.event.DetailsEvent
import com.pacheco.purrfectbreeds.ui.state.DetailsState
import com.pacheco.purrfectbreeds.ui.state.StateResult
import com.purrfectbreeds.usecase.ChangeFavoriteUseCase
import com.purrfectbreeds.usecase.GetBreedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getBreedUseCase: GetBreedUseCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase
) : ViewModel(), BaseViewModel<DetailsEvent, StateResult> {

    override val stateResult: MutableStateFlow<StateResult> = MutableStateFlow(value = StateResult.Loading)

    init {
        viewModelScope.launch {
            getBreedUseCase(id = checkNotNull(savedStateHandle["id"])).collect {
                stateResult.value = StateResult.Success(state = DetailsState(breed = it))
            }
        }
    }

    override fun onEvent(event: DetailsEvent) {
        when(event) {
            is DetailsEvent.ChangeFavorite -> onChangeFavoriteEvent(event = event)
        }
    }

    private fun onChangeFavoriteEvent(event: DetailsEvent.ChangeFavorite) {
        viewModelScope.launch {
            changeFavoriteUseCase(id = event.id)
        }
    }
}