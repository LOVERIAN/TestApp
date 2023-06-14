package com.loverian.testApp.ui.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loverian.testApp.R
import com.loverian.testApp.ui.theme.Converting
import com.loverian.testApp.ui.theme.Downloading
import com.loverian.testApp.ui.theme.Grey
import com.loverian.testApp.ui.theme.Saving
import com.loverian.testApp.ui.theme.TestAppTheme
import com.loverian.testApp.ui.theme.TitleStyle
import java.nio.file.WatchEvent

@Composable
fun MainScreen() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yt_img),
                    contentDescription = "youtube image",
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "You Tube MP3", style = TitleStyle
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            //GrabbingScreen()
            VideoScreen()
        }
    }
}

@Composable
fun VideoScreen() {
    Card() {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            painter = painterResource(id = R.drawable.placeholder),
            contentScale = ContentScale.Fit,
            contentDescription = "Thumbnail"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "Hello World",
            maxLines = 2,
            style = TitleStyle,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.icon_views),
                contentDescription = "Views"
            )
            Text(text = "1.43B Views")
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.icons_likes),
                contentDescription = "Likes"
            )
            Text(text = "1.43B Views")
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    DownloadProgress()
}

@Composable
fun DownloadProgress() {
    var currentState = "Saved"
    var progress = 0.2f
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Downloading",
            style = TitleStyle,
            fontSize = 14.sp
        )
        when (currentState) {
            "Saved" -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon_check),
                    contentDescription = "Check"
                )
            }

            "Failed" -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon_failed),
                    contentDescription = "Failed"
                )

            }

            else -> {
                Text(
                    text = "02:56",
                    style = TitleStyle,
                    fontSize = 14.sp
                )
            }
        }
    }
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        trackColor = when (currentState) {
            "Downloading" -> Downloading
            "Converting" -> Converting
            "Saving" -> Saving
            else -> Grey
        },
        progress = progress
    )
    CustomMessage()
}

@Composable
fun CustomMessage() {
    val message = ""
    Row() {
        Icon(
            painter = if (message == "Success") {
                painterResource(id = R.drawable.icon_check)
            } else {
                painterResource(id = R.drawable.icon_failed)
            },
            contentDescription = "icon"
        )
        Text(text = message)
    }

}

@Composable
fun ProgressIndicator() {
    Row() {
        Text(
            text = "02:56",
            style = TitleStyle,
            fontSize = 14.sp
        )
        Text(
            text = "/",
            style = TitleStyle,
            fontSize = 14.sp
        )
        Text(
            text = "04:56",
            style = TitleStyle,
            fontSize = 14.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrabbingScreen() {
    var text: String = "Hello"
    Text(
        text = "Youtube Link",
        style = TitleStyle,
        fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    CustomTextField(
        "youtube.com",
        "",
        true,
        onValueChange = {
            text = it
        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Folder",
        style = TitleStyle,
        fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "K-Pop Music",
        onValueChange = {})
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(
            modifier = Modifier.size(26.dp),
            painter = painterResource(id = R.drawable.icon_info),
            contentDescription = "info"
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "Where you want to save the mp3",
            fontFamily = FontFamily(
                Font(R.font.pjs_medium)
            )
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        onClick = { /*TODO*/ }) {
        Text(text = "Download")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: String,
    placeholder: String,
    isTrailingIconVisible: Boolean,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(26.dp),
                painter = painterResource(id = R.drawable.icon_link),
                contentDescription = "Link"
            )
        },
        trailingIcon = {
            if (isTrailingIconVisible) {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_clear_24),
                        contentDescription = "Clear"
                    )
                }
            }
        })
}

@Preview
@Composable
fun preview() {
    TestAppTheme {
        MainScreen()
    }
}