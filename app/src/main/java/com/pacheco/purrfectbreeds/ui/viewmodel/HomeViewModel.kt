package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pacheco.purrfectbreeds.HiltApplication
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.pacheco.purrfectbreeds.ui.state.HomeState
import com.pacheco.purrfectbreeds.ui.state.StateResult
import com.purrfectbreeds.usecase.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getImagesUseCase: GetImagesUseCase
) : ViewModel(), BaseViewModel<HomeEvent> {

    override val stateResult: MutableStateFlow<StateResult> = MutableStateFlow(StateResult.Loading)

    init {
        viewModelScope.launch(context = CoroutineExceptionHandler { _, exception ->
            HiltApplication.isLoading = false
        }) {
            stateResult.value = StateResult.Success(state = HomeState(images = getImagesUseCase()))
            HiltApplication.isLoading = false
        }
    }

    override fun onEvent(event: HomeEvent) {
        TODO("Not yet implemented")
    }
}