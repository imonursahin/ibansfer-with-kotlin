package com.example.ibanshare.views

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ibanshare.R
import com.example.ibanshare.viewsmodel.PanelViewModel
import com.example.ibanshare.viewsmodelfactory.PanelViewModelFactory


@Composable
fun PanelScreen(navController: NavController) {

    val context = LocalContext.current
    val viewModel: PanelViewModel = viewModel(
        factory = PanelViewModelFactory(context.applicationContext as Application)
    )
    val ibanList = viewModel.ibanList.observeAsState(listOf())

    Scaffold(
        backgroundColor = colorResource(id = R.color.MainColor),
        topBar = {

            TopAppBar(
                title = { Text(text = "IBANsfer") },
                backgroundColor = colorResource(id = R.color.TopBarColor),
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("InfoScreen") }) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "App ınfo",
                        )
                    }
                }
            )

        },

        content = {
            LazyColumn {
                items(
                    count = ibanList.value!!.count(),
                    itemContent = {
                        val bank = ibanList.value!![it]

                        Card(
                            backgroundColor = colorResource(id = R.color.IbanListColor),
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .padding(all = 10.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "\uD83C\uDFE6  ${bank.ibanBank}",
                                    style = TextStyle(fontSize = 22.sp),
                                    modifier = Modifier
                                        .padding(all = 5.dp)
                                )
                                OutlinedButton(onClick = {}) {

                                    Text(
                                        text = "Paylaş",
                                        style = TextStyle(fontSize = 14.sp),
                                        color = colorResource(id = R.color.Bttn)
                                    )


                                }
                            }

                        }
                    }
                )
            }


        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "+ Ekle")
                },
                onClick = {
                    navController.navigate("AddIbanScreen")
                },

                backgroundColor = colorResource(id = R.color.Bttn),

                )
        },


        )
}


