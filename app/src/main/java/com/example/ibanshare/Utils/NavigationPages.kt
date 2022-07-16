package com.example.ibansfer.utils


sealed class Screen(val route: String) {
    object SplashScreen : Screen("SplashScreen")
    object PanelScreen : Screen("PanelScreen")
    object AddIbanScreen : Screen("AddIbanScreen")
    object InfoScreen : Screen("InfoScreen")

}