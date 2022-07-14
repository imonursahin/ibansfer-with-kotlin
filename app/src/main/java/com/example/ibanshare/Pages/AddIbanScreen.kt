package com.example.ibanshare.Pages

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ibanshare.R


@Composable
fun AddIbanScreen(navController: NavController) {
    Scaffold(
        backgroundColor = colorResource(id = R.color.MainColor),
        topBar = {

            TopAppBar(
                title = { Text(text = "İban Bilgisi Ekle") },
                backgroundColor = colorResource(id = R.color.TopBarColor),
            )
        },

        content = {
            Column {
                var bankName by remember { mutableStateOf(TextFieldValue("")) }
                var IbanOwner by remember { mutableStateOf(TextFieldValue("")) }
                var IbanNumber by remember { mutableStateOf(TextFieldValue("")) }

                OutlinedTextField(
                    value = bankName,
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
                        bankName = it
                    },
                )
                OutlinedTextField(
                    value = IbanOwner,
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
                        IbanOwner = it
                    },
                )
                OutlinedTextField(
                    value = IbanNumber,
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
                        IbanNumber = it
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
                        onClick = { },
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

