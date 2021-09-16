package com.example.domain.usecases

import com.example.domain.models.CompanyModel
import com.example.domain.sources.remote.CompanyRemoteSource
import javax.inject.Inject

class CompanyUseCase @Inject constructor(
    private val companyRemoteSource: CompanyRemoteSource
) {

    fun getCompanyInfo(id: String): CompanyModel {
        return companyRemoteSource.getCompany(id)
    }
}
