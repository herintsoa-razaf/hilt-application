package com.example.local.mappers

import com.example.domain.models.CompanyModel
import com.example.local.db.entities.CompanyEntity

fun CompanyEntity.mapToDomain() =
    CompanyModel(id, name)

fun CompanyModel.mapToLocal() =
    CompanyEntity(id, name)
