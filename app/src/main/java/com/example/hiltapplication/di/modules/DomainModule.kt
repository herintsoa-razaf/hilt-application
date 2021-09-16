package com.example.hiltapplication.di.modules

import com.example.domain.sources.remote.CompanyRemoteSource
import com.example.remote.sources.CompanyRemoteSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    fun providesCompanyRemoteSource(source: CompanyRemoteSourceImp): CompanyRemoteSource
}
