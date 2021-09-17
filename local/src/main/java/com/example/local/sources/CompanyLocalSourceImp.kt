package com.example.local.sources

import com.example.domain.models.CompanyModel
import com.example.domain.sources.local.CompanyLocalSource
import com.example.local.db.dao.CompanyDao
import com.example.local.mappers.mapToDomain
import com.example.local.mappers.mapToLocal
import javax.inject.Inject

class CompanyLocalSourceImp @Inject constructor(
    private val companyDao: CompanyDao
) : CompanyLocalSource {

    override fun getCompany(id: String): CompanyModel {
        return companyDao.get(id).mapToDomain()
    }

    override fun save(model: CompanyModel): Boolean {
        return companyDao.create(model.mapToLocal())
    }

}
