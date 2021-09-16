package com.example.remote.sources

import com.example.domain.models.CompanyModel
import com.example.domain.sources.remote.CompanyRemoteSource
import com.example.remote.mappers.mapToDomain
import com.example.remote.models.requests.CompanyRequest
import com.example.remote.services.CompanyService
import javax.inject.Inject

class CompanyRemoteSourceImp @Inject constructor(
    private val service: CompanyService
): CompanyRemoteSource {

    override fun getCompany(id: String): CompanyModel {
        return service.getCompanyDetails(CompanyRequest(id)).mapToDomain()
    }
}
