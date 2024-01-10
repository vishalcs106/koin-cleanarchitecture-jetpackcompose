package com.android.core.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerGraph(
        navController: NavHostController,
        navigationBuilder: NavGraphBuilder
    )
}