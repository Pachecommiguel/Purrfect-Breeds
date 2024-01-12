package com.pacheco.purrfectbreeds

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

    companion object {
        var isLoading = true
    }
}