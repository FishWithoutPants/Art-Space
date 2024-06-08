package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    var pictureNumber by remember { mutableIntStateOf(1) }
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .safeDrawingPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ArrowButton(
            modifier = Modifier,
            icon = Icons.Rounded.ArrowBack,
            contentDescription = "Arrow back",
            onClick = {
                if (pictureNumber > 1) {
                    pictureNumber--
                } else {
                    pictureNumber = 16
                }
            }
        )
        PictureWithDescription(
            modifier = Modifier,
            painter = when (pictureNumber) {
                1 -> R.drawable.pic1
                2 -> R.drawable.pic2
                3 -> R.drawable.pic3
                4 -> R.drawable.pic4
                5 -> R.drawable.pic5
                6 -> R.drawable.pic6
                7 -> R.drawable.pic7
                8 -> R.drawable.pic8
                9 -> R.drawable.pic9
                10 -> R.drawable.pic10
                11 -> R.drawable.pic11
                12 -> R.drawable.pic12
                13 -> R.drawable.pic13
                14 -> R.drawable.pic14
                15 -> R.drawable.pic15
                16 -> R.drawable.pic16
                else -> R.drawable.lemon_squeeze
            },
            titleText = when (pictureNumber) {
                1 -> R.string.pic1_title
                2 -> R.string.pic2_title
                3 -> R.string.pic3_title
                4 -> R.string.pic4_title
                5 -> R.string.pic5_title
                6 -> R.string.pic6_title
                7 -> R.string.pic7_title
                8 -> R.string.pic8_title
                9 -> R.string.pic9_title
                10 -> R.string.pic10_title
                11 -> R.string.pic11_title
                12 -> R.string.pic12_title
                13 -> R.string.pic13_title
                14 -> R.string.pic14_title
                15 -> R.string.pic15_title
                16 -> R.string.pic16_title
                else -> R.string.pic1_title
            },
            descriptionText = when (pictureNumber) {
                1 -> R.string.pic1_desc
                2 -> R.string.pic2_desc
                3 -> R.string.pic3_desc
                4 -> R.string.pic4_desc
                5 -> R.string.pic5_desc
                6 -> R.string.pic6_desc
                7 -> R.string.pic7_desc
                8 -> R.string.pic8_desc
                9 -> R.string.pic9_desc
                10 -> R.string.pic10_desc
                11 -> R.string.pic11_desc
                12 -> R.string.pic12_desc
                13 -> R.string.pic13_desc
                14 -> R.string.pic14_desc
                15 -> R.string.pic15_desc
                16 -> R.string.pic16_desc
                else -> R.string.pic1_desc
            }
        )
        ArrowButton(
            modifier = Modifier,
            icon = Icons.Rounded.ArrowForward,
            contentDescription = "Arrow forward",
            onClick = {
                if (pictureNumber < 16) {
                    pictureNumber++
                } else {
                    pictureNumber = 1
                }
            }
        )
    }
}

@Composable
fun ArrowButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    Box(modifier = modifier
        .clip(CircleShape)
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
        ) {

        }
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color.Black,
            modifier = modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun PictureWithDescription(
    modifier: Modifier = Modifier,
    painter: Int,
    titleText: Int,
    descriptionText: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            shadowElevation = 4.dp,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(0.5F)
        ) {
            Image(
                painter = painterResource(painter),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(4.dp),
                contentScale = ContentScale.Fit,
                contentDescription = "Image description"
            )
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = stringResource(titleText),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = stringResource(descriptionText))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}