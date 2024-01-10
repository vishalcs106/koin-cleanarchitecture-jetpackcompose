package com.android.feature_home.data.repository

import com.android.feature_home.data.NetworkDataSource
import com.android.feature_home.domain.repository.IHomeRepository

class HomeRepositoryImpl(private val networkDataSource: NetworkDataSource): IHomeRepository {
    override suspend fun loadHtmlContent(url: String): Result<String> {
        return networkDataSource.getHtmlContent(url)
    }
}