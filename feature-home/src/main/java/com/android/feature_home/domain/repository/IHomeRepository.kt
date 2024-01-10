package com.android.feature_home.domain.repository

interface IHomeRepository {
    suspend fun loadHtmlContent(url: String): Result<String>
}