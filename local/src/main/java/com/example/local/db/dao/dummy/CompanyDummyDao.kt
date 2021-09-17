package com.example.local.db.dao.dummy

import android.util.Log
import com.example.local.db.dao.CompanyDao
import com.example.local.db.entities.CompanyEntity
import javax.inject.Inject

class CompanyDummyDao @Inject constructor() : CompanyDao {

    override fun get(id: String) =
        CompanyEntity(id, name = "Company $id")

    override fun create(company: CompanyEntity): Boolean {
        Log.i("CompanyDummyDao", "saving company ${company.id}")
        return true
    }

}
