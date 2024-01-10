package com.android.feature_home.di

import com.google.gson.Gson
import com.android.core.ui.FeatureApi
import com.android.feature_home.data.ApiService
import com.android.feature_home.data.NetworkDataSource
import com.android.feature_home.data.repository.HomeRepositoryImpl
import com.android.feature_home.domain.repository.IHomeRepository
import com.android.feature_home.domain.usecases.GetHtmlContentUseCase
import com.android.feature_home.presentation.HomeApi
import com.android.feature_home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule = module {
    single {
        val retrofit: Retrofit = get()
        retrofit.create(ApiService::class.java)
    }
    single {
        NetworkDataSource(get())
    }
    single<IHomeRepository> {
        HomeRepositoryImpl(get())
    }
    single<FeatureApi> {
        HomeApi()
    }

    single { GetHtmlContentUseCase(get()) }

    single { Gson() }

    viewModel { HomeViewModel(get()) }

}