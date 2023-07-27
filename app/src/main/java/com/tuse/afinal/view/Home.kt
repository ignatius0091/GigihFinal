package com.tuse.afinal.view

import androidx.compose.animation.core.Animatable

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tuse.afinal.R

import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(navController: NavController) {



    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    var isCollapsed =
        scaffoldState.bottomSheetState.isCollapsed

    val animationDuration = 300
    val cornerRadiusCollapsed = 0.dp
    val cornerRadiusExpanded = 25.dp


    val cornerRadiusAnimatable = remember { Animatable(cornerRadiusExpanded.value) }


    LaunchedEffect(isCollapsed) {
        val targetValue =
            if (isCollapsed) cornerRadiusExpanded.value else cornerRadiusCollapsed.value
        cornerRadiusAnimatable.animateTo(targetValue, animationSpec = tween(animationDuration))
    }


    val density = LocalDensity.current
    val cornerRadiusDp = with(density) { cornerRadiusAnimatable.value.dp }



    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 180.dp,
        sheetShape = RoundedCornerShape(topEnd = cornerRadiusDp, topStart = cornerRadiusDp),
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 10.dp),
                    contentAlignment = if (isCollapsed) Alignment.TopCenter else Alignment.CenterStart,
                ) {
                    if (isCollapsed) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_24),
                            contentDescription = "Icon"
                        )
                    } else {
                        Row(
                            Modifier.padding(start = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "",
                                Modifier
                                    .clickable { scope.launch { scaffoldState.bottomSheetState.collapse() } }
                                    .padding(end = 5.dp, top = 4.dp)
                                    .size(20.dp)
                            )
                            Text(
                                text = "Informasi Bencana Terkini",
                                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            )
                        }
                    }
                }

                if (!isCollapsed) Divider(Modifier.fillMaxWidth())

                Column(
                    Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    
                    CardWidget()
                    CardWidget()
                    CardWidget()
                    CardWidget()
                    CardWidget()

                }
            }
        }) {
        Box(
            Modifier
                .background(color = Color(0xff9ea1a2))
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            Box(Modifier.fillMaxWidth()) {
                MapsWidget()
                Box(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .offset(y = 70.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SearchBarWidget(
                                onValuedChange = {}, navController = navController
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            TabBarWidget()
                        }
                    }
                }
            }
        }
    }
}





