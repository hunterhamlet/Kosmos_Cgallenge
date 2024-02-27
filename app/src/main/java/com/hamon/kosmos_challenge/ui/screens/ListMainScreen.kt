package com.hamon.kosmos_challenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hamon.kosmos_challenge.ui.view_models.ListMainViewModel

@Composable
fun ListMainScreen(viewModel: ListMainViewModel = ListMainViewModel()) {

    Surface(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()
    ) {

    }
}

@Preview
@Composable
fun PreviewListMainScreen() {
    ListMainScreen()
}
