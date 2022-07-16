package com.example.ibanshare.views

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ibanshare.R
import com.example.ibanshare.viewsmodel.AddIbanViewModel
import com.example.ibanshare.viewsmodelfactory.AddIbanViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun AddIbanScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val snackbarCoroutineScope = rememberCoroutineScope()

    val ibanOwner = remember { mutableStateOf("") }
    val ibanBank = remember { mutableStateOf("") }
    val ibanNumber = remember { mutableStateOf("") }

    val localFocusManager = LocalFocusManager.current

    val context = LocalContext.current
    val viewModel: AddIbanViewModel = viewModel(
        factory = AddIbanViewModelFactory(context.applicationContext as Application)
    )

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = colorResource(id = R.color.MainColor),
        topBar = {

            TopAppBar(
                title = { Text(text = "İban Bilgisi Ekle") },
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
            Column {


                OutlinedTextField(
                    value = ibanBank.value,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Alıcı Adı",
                            style = TextStyle(
                                color = colorResource(id = R.color.white)
                            )
                        )
                    },
                    placeholder = { Text(text = "Onur Şahin") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.FocusColor),
                        unfocusedBorderColor = colorResource(id = R.color.white)
                    ),
                    onValueChange = {
                        ibanBank.value = it
                    },
                )
                OutlinedTextField(
                    value = ibanOwner.value,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Banka Adı",
                            style = TextStyle(
                                color = colorResource(id = R.color.white)
                            )
                        )
                    },
                    placeholder = { Text(text = "ABC Bank") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.FocusColor),
                        unfocusedBorderColor = colorResource(id = R.color.white)
                    ),
                    onValueChange = {
                        ibanOwner.value = it
                    },
                )
                OutlinedTextField(
                    value = ibanNumber.value,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "İban Numarası",
                            style = TextStyle(
                                color = colorResource(id = R.color.white)
                            )
                        )
                    },
                    placeholder = { Text(text = "TRXXXXXXXXXXXXXXX") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.FocusColor),
                        unfocusedBorderColor = colorResource(id = R.color.white)
                    ),
                    onValueChange = {
                        ibanNumber.value = it
                    },
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(12.dp)
                ) {
                    Button(
                        onClick = {
                            if (ibanBank.value.isNotEmpty() && ibanOwner.value.isNotEmpty() && ibanNumber.value.isNotEmpty()) {

                                viewModel.addData(
                                    ibanBank.value,
                                    ibanOwner.value,
                                    ibanNumber.value
                                )
                                localFocusManager.clearFocus()
                                navController.popBackStack()

                            } else {

                                snackbarCoroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar("Tüm alanları doldurun")
                                }


                            }


                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.Bttn),
                            contentColor = colorResource(id = R.color.white)
                        )
                    ) {
                        Text("Kaydet")
                    }
                }


            }


        })

}

