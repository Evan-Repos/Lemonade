package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1)}
    var clickCount by remember { mutableStateOf(0) }
    var requiredClicks = remember { (2..5).random() }
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Yellow header with text "Lemoned"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFFF9E44C))
            ) {
                Text(
                    text = "Lemonade",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .align(Alignment.Center)
                )
            }
        }
        when (currentStep) {
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(
                        text = stringResource(R.string.motivation_shubham),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp,
                        modifier = Modifier
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.get_lemon_from_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                            }
                            .clip(shape = RoundedCornerShape(26.dp))
                            .background(Color(0xFFC3ECD2))
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Text(
                        text = stringResource(R.string.get_lemon_from_tree),
                        fontSize = 18.sp,
                        modifier = Modifier

                    )
                }
            }
            2 -> {
                LaunchedEffect(Unit) {
                    clickCount = 0
                    requiredClicks = (2..4).random()
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(
                        text = stringResource(R.string.empty),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp,
                        modifier = Modifier
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.squeeze_lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable{
                                clickCount++
                                if (clickCount >= requiredClicks) {
                                    currentStep = 3
                                }
                            }
                            .clip(shape = RoundedCornerShape(26.dp))
                            .background(Color(0xFFC3ECD2))
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Text(
                        text = stringResource(R.string.squeeze_lemon),
                        fontSize = 18.sp,
                        modifier = Modifier
                    )
                }
            }
            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = stringResource(R.string.empty),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp,
                        modifier = Modifier
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.drink_lemonade),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable{
                                currentStep = 4
                            }
                            .clip(shape = RoundedCornerShape(26.dp))
                            .background(Color(0xFFC3ECD2))
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Text(
                        text = stringResource(R.string.drink_lemonade),
                        fontSize = 18.sp,
                        modifier = Modifier
                    )
                }
            }
            4 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = stringResource(R.string.compliment_shubham),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp,
                        modifier = Modifier
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.restart),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable{
                                currentStep = 1
                            }
                            .clip(shape = RoundedCornerShape(26.dp))
                            .background(Color(0xFFC3ECD2))
                    )
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )
                    Text(
                        text = stringResource(R.string.restart),
                        fontSize = 18.sp,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}