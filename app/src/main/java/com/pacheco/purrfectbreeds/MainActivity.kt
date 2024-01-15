package com.pacheco.purrfectbreeds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.paging.LoadState
import com.pacheco.purrfectbreeds.router.ApplicationNavHost
import com.pacheco.purrfectbreeds.ui.theme.PurrfectBreedsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        installSplashScreen().setKeepOnScreenCondition {
            HiltApplication.loadState is LoadState.Loading
        }

        setContent {
            PurrfectBreedsTheme {
                ApplicationNavHost()
            }
        }
    }
}