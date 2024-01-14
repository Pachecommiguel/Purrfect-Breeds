package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pacheco.purrfectbreeds.ui.event.FavoritesEvent
import com.pacheco.purrfectbreeds.ui.state.FavoritesState
import com.pacheco.purrfectbreeds.ui.state.StateResult
import com.purrfectbreeds.model.BreedModel
import com.purrfectbreeds.usecase.GetFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    getFavoritesUseCase: GetFavoritesUseCase
) : ViewModel(), BaseViewModel<FavoritesEvent, StateResult> {

    override val stateResult: MutableStateFlow<StateResult> = MutableStateFlow(value = StateResult.Loading)

    init {
        viewModelScope.launch {
            getFavoritesUseCase().collect {
                stateResult.value = StateResult.Success(state = FavoritesState(
                    favorites = it.filter(BreedModel::isFavorite))
                )
            }
        }
    }

    override fun onEvent(event: FavoritesEvent) {

    }
}