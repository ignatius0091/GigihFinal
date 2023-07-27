package com.tuse.afinal.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
fun MapsWidget() {

    var latLang = LatLng(-1.269160, 116.825264)
    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLang, 13f)
    }

    GoogleMap(

        modifier = Modifier.fillMaxWidth(),
        cameraPositionState = cameraPositionState,

    ) {
        Marker(
            state = MarkerState(position = latLang),
            title = "Balikpapan",
            snippet = "Marker in Balikpapan"
        )
    }

}