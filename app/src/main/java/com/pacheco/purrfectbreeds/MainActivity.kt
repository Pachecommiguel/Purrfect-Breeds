package com.pacheco.purrfectbreeds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pacheco.purrfectbreeds.router.ApplicationNavHost
import com.pacheco.purrfectbreeds.ui.theme.PurrfectBreedsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        installSplashScreen().setKeepOnScreenCondition(HiltApplication.Companion::isLoading)
        setContent {
            PurrfectBreedsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ApplicationNavHost()
                }
            }
        }
    }
}