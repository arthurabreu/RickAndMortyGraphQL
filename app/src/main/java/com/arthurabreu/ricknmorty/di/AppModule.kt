package com.arthurabreu.ricknmorty.di

import com.apollographql.apollo3.ApolloClient
import com.arthurabreu.ricknmorty.domain.ApolloRMClient
import com.arthurabreu.ricknmorty.domain.RMClient
import com.arthurabreu.ricknmorty.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideApolloRMClient(apolloClient: ApolloClient): RMClient {
        return ApolloRMClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(rmClient: RMClient): GetCharactersUseCase {
        return GetCharactersUseCase(rmClient)
    }
}