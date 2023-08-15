package com.tuse.afinal.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tuse.afinal.R
import com.tuse.afinal.model.Geometry
import coil.request.ImageRequest


@Composable
fun CardWidget(geometry: Geometry) {


    Card(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = ImageRequest
                    .Builder(context = LocalContext.current)
                    .data(geometry.properties.imageUrl)
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .padding(20.dp)
            )
            Column {

                Text(
                    text = stringResource(
                        R.string.bencana,
                        geometry.properties.reportData.reportType
                    )
                )
                Text(text = stringResource(R.string.waktu, geometry.properties.createdAt))
            }
        }
    }
}

@Composable
fun DisasterGridWidget(geometries: List<Geometry>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(4.dp),

        modifier = Modifier.fillMaxWidth(),
    ) {
        items(items = geometries, key = { geometry -> geometry.properties.pkey }) { geometry ->
            CardWidget(geometry = geometry)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading",
        modifier = modifier.size(200.dp)

    )
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = ""
        )
        Text(
            text = stringResource(R.string.loading_failed),
            modifier = Modifier.padding(16.dp)
        )

    }
}

@Composable
fun DisasterGridState(disasterUiState: DisasterUiState, modifier: Modifier = Modifier) {
    when(disasterUiState){
        is DisasterUiState.Success -> DisasterGridWidget(geometries = disasterUiState.geometries)
        is DisasterUiState.Loading -> LoadingScreen(modifier.fillMaxSize())
        else -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }
}


