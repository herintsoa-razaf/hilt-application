package com.example.remote.services

import com.example.remote.models.requests.CompanyRequest
import com.example.remote.models.responses.Company

interface CompanyService {
    fun getCompanyDetails(request: CompanyRequest): Company
}
