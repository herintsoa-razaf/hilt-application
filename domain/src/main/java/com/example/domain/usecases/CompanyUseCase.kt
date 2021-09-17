package com.example.domain.usecases

import com.example.domain.models.CompanyModel
import com.example.domain.sources.local.CompanyLocalSource
import com.example.domain.sources.remote.CompanyRemoteSource
import javax.inject.Inject

class CompanyUseCase @Inject constructor(
    private val companyRemoteSource: CompanyRemoteSource,
    private val companyLocalSource: CompanyLocalSource
) {

    fun getCompanyInfo(id: String): CompanyModel {
        return companyRemoteSource.getCompany(id).also(companyLocalSource::save)
    }

}
