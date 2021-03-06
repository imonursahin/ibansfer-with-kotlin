package com.example.ibansfer.views

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ibansfer.utils.Screen
import com.example.ibanshare.R
import kotlinx.coroutines.delay

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0f) }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        delay(2500L)
        navController.popBackStack()
        navController.navigate(Screen.PanelScreen.route)

    }

    Scaffold(
        backgroundColor = colorResource(
            id = R.color.MainColor,
        )
    ) {


        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.MainColor))
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.splashicon),
                    contentDescription = "Splash Screen",
                    modifier = Modifier
                        .scale(scale.value)
                        .height(225.dp)
                        .width(225.dp)
                )

                Text(
                    text = "IBANsfer",
                    style = TextStyle(
                        fontSize = 48.sp,
                        color = colorResource(id = R.color.SplashTitle)
                    ),
                )
                Text(
                    text = "iban payla??man??n en kolay hali",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.SplashDesc)
                    ),
                )
            }
        }
    }


}
