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
import com.example.ibanshare.views.PanelScreen
import com.example.ibansfer.views.SplashScreen
import com.example.ibansfer.utils.Screen
import com.example.ibanshare.views.AddIbanScreen
import com.example.ibanshare.ui.theme.IbanShareTheme
import com.example.ibanshare.views.InfoScreen


class MainActivity : ComponentActivity() {

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
        composable(Screen.InfoScreen.route) { InfoScreen(navController = navController) }

    }
}
