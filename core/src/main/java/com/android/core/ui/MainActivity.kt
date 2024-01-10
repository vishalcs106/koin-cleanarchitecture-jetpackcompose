package com.android.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.core.navigation.NavigationProvider
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val navigationProvider: NavigationProvider by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            App(navController, navigationProvider)
        }
    }
}

@Composable
fun App(navHostController: NavHostController, navigationProvider: NavigationProvider){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavGraph(navHostController, navigationProvider = navigationProvider)
    }
}

