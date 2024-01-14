package com.pacheco.purrfectbreeds

import android.app.Application
import androidx.paging.LoadState
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

    companion object {
        var loadState: LoadState = LoadState.Loading
    }
}