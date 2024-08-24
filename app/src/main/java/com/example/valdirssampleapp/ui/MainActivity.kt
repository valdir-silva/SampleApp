package com.example.valdirssampleapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.example.valdirssampleapp.ui.mockSelection.MockSelectionScreen
import com.example.valdirssampleapp.ui.theme.ServerDrivenUISampleTheme
import com.example.valdirssampleapp.ui.theme.ValdirsSampleAppTheme
import com.example.valdirssampleapp.ui.userList.UserListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServerDrivenUISampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "mock_selections") {
                        composable("mock_selections") { MockSelectionScreen(navController = navController) }
                        composable("user_list") { UserListScreen() }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ValdirsSampleAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "mock_selections") {
                composable("mock_selections") { MockSelectionScreen(navController = navController) }
                composable("user_list") { UserListScreen() }
            }
        }
    }
}