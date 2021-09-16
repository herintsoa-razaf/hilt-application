package com.example.remote.services.dummy

import com.example.remote.models.requests.CompanyRequest
import com.example.remote.models.responses.Company
import com.example.remote.services.CompanyService
import javax.inject.Inject


class CompanyDummyService @Inject constructor() : CompanyService {

    override fun getCompanyDetails(request: CompanyRequest): Company {
        return Company(id = request.id, name = "Company ${request.id}")
    }

}
