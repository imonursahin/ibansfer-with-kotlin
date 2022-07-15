package com.example.ibanshare.Views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ibanshare.R


@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        backgroundColor = colorResource(id = R.color.MainColor),
        topBar = {

            TopAppBar(
                title = { Text(text = "IBANsfer Nedir?") },
                backgroundColor = colorResource(id = R.color.TopBarColor),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )

        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 12.dp)
            ) {

                Text(
                    text = "IBAN bilgilerinizi tek bir yerden erişebilmenize ve yönetmenize olanak sağlayan ücretsiz ve güvenli bir uygulamadır. \uD83C\uDD93 ✅ \uD83D\uDE0D  \n" +
                            "\n" + "IBAN numaralarının telefonda güvenli bir şekilde saklanmasını ve gerektiğinde paylaşılmasını sağlamaktadır." +
                            " \n\n\n  \uD83D\uDCE9   ibansfer@gmail.com",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = colorResource(id = R.color.white)
                    )
                )


            }
        },


        )
}


