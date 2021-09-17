package com.example.local.db.dao

import com.example.local.db.entities.CompanyEntity

interface CompanyDao {

    fun get(id: String): CompanyEntity

    fun create(company: CompanyEntity): Boolean

}
