package com.android.feature_home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android.core.ui.FeatureApi

class HomeApi: FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navigationBuilder: NavGraphBuilder
    ) {
        navigationBuilder.navigation(startDestination = "home", route = "home_navigation"){
            composable("home"){
                HomeScreen()
            }
        }
    }
}