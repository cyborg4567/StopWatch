package com.example.stopwatch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun GettingStarted(navigationToStopWatch:() -> Unit) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.clock))

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "TASK - 03",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold)

        LottieAnimation(
            modifier = Modifier.size(250.dp),
            composition = composition,
            iterations = LottieConstants.IterateForever)

        Button(
            onClick = { navigationToStopWatch() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8E153),
                contentColor = Color.Black)
        ) {
            Text(text = "Go to Stop Watch",
                fontSize = 15.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GettingStartedPreview() {
//    GettingStarted()
}