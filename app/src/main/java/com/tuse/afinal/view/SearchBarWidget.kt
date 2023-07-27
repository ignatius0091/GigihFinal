package com.tuse.afinal.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.tuse.afinal.R


@Composable
fun SearchBarWidget(
    hint: String = "Cari Disini",
    onValuedChange: (String) -> Unit,
    navController: NavController
) {
    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onValuedChange(newText)
        },
        trailingIcon = {
            Box(modifier = Modifier.size(20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                    contentDescription = "",
                    modifier = Modifier.clickable {

                            navController.navigate("setting")

                    })
            }
        },
        placeholder = { Text(text = hint) },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.White,
            cursorColor = Color.Black,
            focusedBorderColor = Color.Gray
        ),
        modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(30.dp))
    )


}