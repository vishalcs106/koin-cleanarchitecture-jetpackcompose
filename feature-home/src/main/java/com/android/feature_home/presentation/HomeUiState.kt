package com.android.feature_home.presentation

sealed class HomeUiState{
     object Loading: HomeUiState()
     data class Error(val message: String): HomeUiState()
     data class Success(val homeUiModel: HomeUiModel)
}