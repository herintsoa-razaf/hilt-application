package com.example.domain.sources.local

import com.example.domain.models.CompanyModel

interface CompanyLocalSource {

    fun getCompany(id: String): CompanyModel

    fun save(model: CompanyModel): Boolean

}
