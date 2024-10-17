package com.ismael.imagegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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

    var result by remember { mutableStateOf(1) }

    var art = when(result){
        1 -> R.drawable.skeleton_photo
        2 -> R.drawable.night
        else -> R.drawable.self
    }

    var description   = when(result){
        1 -> R.string.art_description_1
        2 -> R.string.art_description_2
        else -> R.string.art_description_3
    }

    var author = when(result){
            1 -> R.string.artist_name_1
            2 -> R.string.artist_name_2
            else -> R.string.artist_name_3
        }



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= modifier
            .fillMaxSize()
    ) {
        ArtWall(art)
        ArtDescription(
            description,
            author,
            modifier = modifier.padding(10.dp),
        )
        ArtButtonControls(
            onPreviousClick = {
                result = if (result > 1) result - 1 else 3 // ajusta para 3 imagens
            },
            onNextClick = {
                result = if (result < 3) result + 1 else 1 // ajusta para 3 imagens
            }
        )
    }
}

@Composable
fun ArtWall(
    art: Int,
    modifier: Modifier = Modifier
){

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(8.dp, shape = RoundedCornerShape(8.dp))
            .background(Color.White, shape = RoundedCornerShape(8.dp))

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(art),
                contentDescription = "Skeleton photo",
                modifier = Modifier
                    .padding(24.dp)
            )
        }
    }

}

@Composable
fun ArtDescription(
    description: Int,
    author: Int,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(description),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(author),
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
fun ArtButtonControls(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
){


     Row(
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.Center,
       modifier = modifier
           .fillMaxWidth()
     ) {
        Button(
            onClick =  onPreviousClick,
            modifier = Modifier.size(width = 150.dp, height = 50.dp)
        ) {
            Text(stringResource(R.string.previous_button))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onNextClick,
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