package com.android.feature_home.domain.usecases

import com.android.feature_home.domain.repository.IHomeRepository

class GetHtmlContentUseCase(private val repository: IHomeRepository) {
    suspend fun execute(url: String): Result<String> {
        return repository.loadHtmlContent(url)
    }
}