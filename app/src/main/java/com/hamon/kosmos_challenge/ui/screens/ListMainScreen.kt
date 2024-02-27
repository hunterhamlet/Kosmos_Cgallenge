package com.hamon.kosmos_challenge.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hamon.kosmos_challenge.ui.components.CharacterCardComponent
import com.hamon.kosmos_challenge.ui.view_models.ListMainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListMainScreen(viewModel: ListMainViewModel = koinViewModel()) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = 0) {
        viewModel.getCharacters()
    }

    if (uiState.isNotEmpty()) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(  )
        ) {
            items(items = uiState) { item ->
                CharacterCardComponent(characterUI = item)
            }
        }
    } else {
        // Show empty state
    }

}

@Preview
@Composable
fun PreviewListMainScreen() {
    ListMainScreen()
}
