package com.android.feature_home.presentation

data class HomeUiModel(
    val fifteenthCharacter: String,
    val everyFifteenthCharacter: List<String>,
    val wordCount: Map<String, Int>)