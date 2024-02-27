package com.hamon.kosmos_challenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hamon.kosmos_challenge.ui.model.CharacterUI

@Composable
fun CharacterCardComponent(characterUI: CharacterUI) {

    // Flag to expand
    var expanded by remember { mutableStateOf(false) }

    // Internal card
    Box(modifier = Modifier.padding(vertical = 8.dp)) {
        Card(modifier = Modifier.width(200.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = characterUI.image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = characterUI.name,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Spacer(Modifier.height(8.dp))
                Button(onClick = { expanded = !expanded }) {
                    Text(
                        text = if (!expanded) "Ver detalle" else "Ocultar detalle",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                }
                Spacer(Modifier.height(8.dp))
                if (expanded) {
                    Text(
                        text = "Status: ${characterUI.status}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Species: ${characterUI.species}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Type: ${characterUI.type}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Gender: ${characterUI.gender}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Origin: ${characterUI.originName}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CharacterCardComponentPreview() {
    CharacterCardComponent(
        characterUI = CharacterUI(
            gender = "Mx",
            id = 0,
            image = "",
            locationName = "",
            name = "Lalo Landa",
            originName = "",
            species = "",
            status = "",
            type = ""
        )
    )
}