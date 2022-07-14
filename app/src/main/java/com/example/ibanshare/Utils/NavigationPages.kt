package com.example.ibansfer.Utils


sealed class Screen(val route: String) {
    object SplashScreen : Screen("SplashScreen")
    object PanelScreen : Screen("PanelScreen")
}