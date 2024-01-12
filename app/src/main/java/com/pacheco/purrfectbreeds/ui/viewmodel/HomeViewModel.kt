package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.pacheco.purrfectbreeds.ui.state.StateResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel(), BaseViewModel<HomeEvent> {

    override val stateResult: MutableStateFlow<StateResult> = MutableStateFlow(StateResult.Loading)

    init {

    }

    override fun onEvent(event: HomeEvent) {
        TODO("Not yet implemented")
    }
}