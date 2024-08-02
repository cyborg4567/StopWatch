package com.example.stopwatch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopWatch(formattedTime: String, onStartClick:() -> Unit, onPauseClick:() -> Unit, onResetClick:() -> Unit) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = formattedTime,
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp)
        Spacer(Modifier.height(100.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { onStartClick()},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8E153),
                    contentColor = Color.Black)) {
                Text(text = "Play")
            }
            Button(onClick = { onPauseClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8E153),
                    contentColor = Color.Black)) {
                Text(text = "Pause")
            }
            Button(onClick = { onResetClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8E153),
                    contentColor = Color.Black)) {
                Text(text = "Reset")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StopWatchPreview() {
    StopWatch("00:00:000", {}, {}, {})
}