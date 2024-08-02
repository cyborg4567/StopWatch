package com.example.stopwatch

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Watch {
    var formattedTime by mutableStateOf("00:00:000")
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private var isActive = false
    private var timeMillis = 0L
    private var lastTimeStamp = 0L

    @RequiresApi(Build.VERSION_CODES.O)
    fun start() {
        if(isActive) return

        coroutineScope.launch {
            lastTimeStamp = System.currentTimeMillis()
            this@Watch.isActive = true
            while (this@Watch.isActive) {
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimeStamp
                lastTimeStamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatTime(timeMillis: Long): String {
//        val localDateTime = LocalDateTime.ofInstant(
//            Instant.ofEpochMilli(timeMillis),
//            ZoneId.systemDefault()
//        )
//        val formatter = DateTimeFormatter.ofPattern(
//            "mm:ss:SSS", Locale.getDefault()
//        )
//        return localDateTime.format(formatter)

        val minutes = (timeMillis / 1000) / 60
        val seconds = (timeMillis / 1000) % 60
        val millis = timeMillis % 1000
        return String.format("%02d:%02d:%03d", minutes, seconds, millis)
    }

    fun pause() {
        isActive  = false
    }

    fun reset() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        timeMillis = 0L
        lastTimeStamp = 0L
        formattedTime = "00:00:000"
        isActive = false
    }




}