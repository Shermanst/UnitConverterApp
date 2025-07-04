package com.example.unitconverterapp.di

import com.example.unitconverterapp.util.Converter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ConverterModule {

    @Provides
    @Singleton
    fun provideConverter(): Converter = Converter
}
