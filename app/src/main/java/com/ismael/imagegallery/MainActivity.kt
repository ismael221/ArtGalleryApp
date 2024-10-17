package com.ismael.imagegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ismael.imagegallery.ui.theme.ImageGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ImageGalleryLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
        }
    }
}

@Composable
fun ImageGalleryLayout(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= modifier
            .fillMaxSize()
    ) {
        ArtWall()
        ArtDescription(
            modifier = modifier.padding(10.dp)
        )
        ArtButtonControls()
    }
}

@Composable
fun ArtWall(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(8.dp, shape = RoundedCornerShape(8.dp)) // Aplica a sombra
            .background(Color.White, shape = RoundedCornerShape(8.dp)) // Define o fundo e o formato

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.skeleton_photo),
                contentDescription = "Skeleton photo",
                modifier = Modifier
                    .padding(24.dp)
            )
        }
    }

}

@Composable
fun ArtDescription(
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Head of a Skeleton with a Burning Cigarette",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Vincent van Gogh (1886)",
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
fun ArtButtonControls(
    modifier: Modifier = Modifier
){
     Row(
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.Center,
       modifier = modifier
           .fillMaxWidth()
     ) {
        Button(
            onClick = {},
            modifier = Modifier.size(width = 150.dp, height = 50.dp)
        ) {
            Text(stringResource(R.string.previous_button))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = {},
            modifier = Modifier.size(width = 150.dp, height = 50.dp)
        ) {
                Text(stringResource(R.string.next_button))
        }
     }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageGalleryTheme {
        ImageGalleryLayout()
    }
}