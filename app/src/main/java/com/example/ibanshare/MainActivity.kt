package com.example.ibanshare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ibansfer.Pages.PanelScreen
import com.example.ibansfer.Pages.SplashScreen
import com.example.ibansfer.Utils.Screen
import com.example.ibanshare.Pages.AddIbanScreen
import com.example.ibanshare.ui.theme.IbanShareTheme
import kotlinx.coroutines.DelicateCoroutinesApi


class MainActivity : ComponentActivity() {

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IbanShareTheme {

                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@DelicateCoroutinesApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) { SplashScreen(navController = navController) }
        composable(Screen.PanelScreen.route) { PanelScreen(navController = navController) }
        composable(Screen.AddIbanScreen.route) { AddIbanScreen(navController = navController) }
    }
}
