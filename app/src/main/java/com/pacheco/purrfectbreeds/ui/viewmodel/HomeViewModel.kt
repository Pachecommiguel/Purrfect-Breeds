package com.pacheco.purrfectbreeds.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pacheco.purrfectbreeds.HiltApplication
import com.pacheco.purrfectbreeds.ui.event.HomeEvent
import com.purrfectbreeds.model.ImageModel
import com.purrfectbreeds.usecase.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getImagesUseCase: GetImagesUseCase
) : ViewModel(), BaseViewModel<HomeEvent, PagingData<ImageModel>> {

    override val state = MutableStateFlow<PagingData<ImageModel>>(value = PagingData.empty())

    init {
        viewModelScope.launch(context = CoroutineExceptionHandler { _, exception ->
            HiltApplication.isLoading = false
        }) {
            getImagesUseCase().cachedIn(scope = this).collect {
                state.value = it
                HiltApplication.isLoading = false
            }
        }
    }

    override fun onEvent(event: HomeEvent) {
        TODO("Not yet implemented")
    }
}