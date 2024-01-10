package com.android.core.ui

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.core.navigation.NavigationProvider

@Composable
fun AppNavGraph(navHostController: NavHostController, navigationProvider: NavigationProvider){
    NavHost(navController = navHostController, startDestination="home_navigation"){
        navigationProvider.featureApi.registerGraph(
            navHostController, this
        )
    }
}