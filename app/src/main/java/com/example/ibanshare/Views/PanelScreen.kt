package com.example.ibanshare.views

import android.app.Application
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
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

    LaunchedEffect(key1 = true) {
        viewModel.loadData()
    }

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

                },
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

                                Row {

                                    IconButton(modifier = Modifier.then(Modifier.size(48.dp)),
                                        onClick = { viewModel.deleteData(bank.ibanId) }) {
                                        Icon(
                                            Icons.Filled.Delete,
                                            "contentDescription",
                                            tint = Color.Red
                                        )
                                    }

                                    IconButton(modifier = Modifier.then(Modifier.size(48.dp)),
                                        onClick = {

                                            val type = "text/plain"
                                            val extraText =
                                                "Banka: ${bank.ibanBank} \n  Alıcı Adı: ${bank.ibanOwner} \n IBAN: ${bank.ibanNumber} \n IBANsfer aracılığıyla gönderildi."
                                            val shareWith = ""

                                            val intent = Intent(Intent.ACTION_SEND)
                                            intent.type = type
                                            intent.putExtra(Intent.EXTRA_TEXT, extraText)

                                            ContextCompat.startActivity(
                                                context,
                                                Intent.createChooser(intent, shareWith),
                                                null
                                            )
                                        }) {
                                        Icon(
                                            Icons.Filled.Share,
                                            "contentDescription",
                                            tint = colorResource(id = R.color.Bttn)
                                        )
                                    }

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


