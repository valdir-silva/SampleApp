package com.example.valdirssampleapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.valdirssampleapp.networking.ApiService
import com.example.valdirssampleapp.ui.mockSelection.MockSelectionScreen
import com.example.valdirssampleapp.ui.theme.ServerDrivenUISampleTheme
import com.example.valdirssampleapp.ui.userList.HomeScreen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServerDrivenUISampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
                ) {
                    val apiService = inject<ApiService>().value
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "mock_selections") {
                        composable("mock_selections") {
                            MockSelectionScreen(
                                navController = navController,
                                apiService = apiService
                            )
                        }
                        composable("home") { HomeScreen() }
                    }
                }
            }
        }
    }
}