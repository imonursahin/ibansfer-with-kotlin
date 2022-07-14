package com.example.ibansfer.Pages


import android.util.Log
import android.widget.ListAdapter
import android.widget.ListView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ibanshare.R


@Composable
fun PanelScreen(navController: NavController) {
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
            Column {

                val ibanList =
                    remember { mutableStateListOf("Akbank") }

                LazyColumn {
                    items(
                        count = ibanList.count(),
                        itemContent = {
                            val bankName = ibanList[it]

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
                                        text = "\uD83C\uDFE6  " + bankName,
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


