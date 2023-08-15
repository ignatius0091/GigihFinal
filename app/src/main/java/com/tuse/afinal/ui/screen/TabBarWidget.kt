package com.tuse.afinal.ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TabBarWidget() {

    val tabs = listOf("Banjir", "Badai", "Gempa", "Kabut", "Kebakaran")
    var selectedTabIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(selectedTabIndex = selectedTabIndex,
        contentColor = Color.White,
        backgroundColor = Color.Transparent,
        edgePadding = 16.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = Color.Gray
            )
        },
        divider = {}) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index, onClick = { selectedTabIndex = index },
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.White),
            ) {
                Row() {
                    Text(text = title)

                }
            }
        }
    }
}