package com.arthurabreu.ricknmorty.di

import com.arthurabreu.ricknmorty.navigation.NavigationManager
import com.arthurabreu.ricknmorty.navigation.NavigationManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Singleton
    @Provides
    fun provideNavigationManager(): NavigationManager {
        return NavigationManagerImpl()
    }
}
