package com.tuse.afinal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tuse.afinal.R
import com.tuse.afinal.models.Properties

@Composable
fun CardWidget() {


    Card(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_img_placeholder),
                contentDescription = "",
                Modifier
                    .size(150.dp)
                    .padding(20.dp)
            )
            Column() {

                Text(text = "Bencana: ")
                Text(text = "Waktu: ")
            }
        }
    }
}