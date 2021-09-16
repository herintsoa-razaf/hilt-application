package com.example.hiltapplication.di.modules

import com.example.remote.services.CompanyService
import com.example.remote.services.dummy.CompanyDummyService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {

    @Binds
    fun providesCompanyService(service: CompanyDummyService): CompanyService
}
