package com.android.core.di

import com.android.core.navigation.NavigationProvider
import org.koin.dsl.module

val coreModule = module {
    single { NavigationProvider(get()) }
}