package com.example.presenter.mappers

import com.example.domain.models.CompanyModel
import com.example.presenter.models.Company

fun CompanyModel.mapToPresenter() = Company(id, name)
