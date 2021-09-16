package com.example.domain.sources.remote

import com.example.domain.models.CompanyModel

interface CompanyRemoteSource {

    fun getCompany(id: String): CompanyModel
}
