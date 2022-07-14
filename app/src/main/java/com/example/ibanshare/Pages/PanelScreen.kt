package com.example.ibansfer.Pages


import android.widget.ListAdapter
import android.widget.ListView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
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
            )
        },

        content = {
            Column {

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


