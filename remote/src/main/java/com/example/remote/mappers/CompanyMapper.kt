package com.example.remote.mappers

import com.example.domain.models.CompanyModel
import com.example.remote.models.responses.Company

fun Company.mapToDomain() = CompanyModel(id, name)
