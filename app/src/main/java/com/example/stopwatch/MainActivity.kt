package com.example.stopwatch

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stopwatch.ui.theme.StopWatchTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StopWatchTheme {
//                GettingStarted()
//                val stopWatch = remember { Watch()}
//                StopWatch(
//                    formattedTime = stopWatch.formattedTime,
//                    onStartClick = stopWatch::start,
//                    onPauseClick = stopWatch::pause,
//                    onResetClick = stopWatch::reset)
                StopWatchNavigation()

            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StopWatchNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination ="GettingStarted" ) {
        composable("gettingstarted") {
            GettingStarted{
                navController.navigate("Stopwatch")
            }
        }
        composable("Stopwatch") {
            val stopWatch = remember { Watch()}
                StopWatch(
                    formattedTime = stopWatch.formattedTime,
                    onStartClick = stopWatch::start,
                    onPauseClick = stopWatch::pause,
                    onResetClick = stopWatch::reset)
        }
    }
}
