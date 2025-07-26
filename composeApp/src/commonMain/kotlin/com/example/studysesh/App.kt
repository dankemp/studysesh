package com.example.studysesh

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.graphics.Shape
//import androidx.compose.ui.geometry.Size
//import kotlin.math.sqrt
import studysesh.composeapp.generated.resources.Res
import studysesh.composeapp.generated.resources.compose_multiplatform




val EquilateralTriangleShape: Shape = GenericShape { size, _ ->
    val height = size.height
    val width = height
    moveTo(0f, height / 2) // Left middle point
    lineTo(width, height / 2) // Right point
    lineTo(0f, height) // Bottom left point
    close()
}



@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize()
                .padding(start = 32.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
            }


            Button(
                onClick = {showContent = !showContent},
                shape = EquilateralTriangleShape,
                modifier = Modifier
                    .align(Alignment.TopEnd as Alignment.Vertical)
                    .size(40.dp),
                contentPadding = PaddingValues(0.dp)
            ){

            }

            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}


