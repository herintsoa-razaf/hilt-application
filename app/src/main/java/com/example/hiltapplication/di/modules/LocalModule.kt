package com.example.hiltapplication.di.modules

import com.example.local.db.dao.CompanyDao
import com.example.local.db.dao.dummy.CompanyDummyDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {

    @Binds
    fun providesCompanyDao(dao: CompanyDummyDao): CompanyDao

}
