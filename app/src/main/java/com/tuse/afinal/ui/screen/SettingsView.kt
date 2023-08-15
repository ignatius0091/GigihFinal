package com.tuse.afinal.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingView(navController: NavController) {
    var switchState by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        Surface(shadowElevation = 12.dp) {
            CenterAlignedTopAppBar(
                title = { Text(text = "Settings") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    }, content = { innerPadding ->
        Row(
            Modifier
                .padding(innerPadding)
                .then(Modifier.padding(horizontal = 20.dp, vertical = 10.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(checked = switchState, onCheckedChange = {switchState = !switchState})
            Spacer(modifier = Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Dark Mode",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                )
                Text(
                    text = "Enable dark mode",
                    style = TextStyle(fontWeight = FontWeight.W300),
                )
            }
        }

    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingViewPreview() {
    SettingView(navController = rememberNavController())
}
