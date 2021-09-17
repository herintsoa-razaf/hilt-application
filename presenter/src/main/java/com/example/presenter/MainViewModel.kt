package com.example.presenter

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.providers.DispatcherProvider
import com.example.domain.usecases.CompanyUseCase
import com.example.presenter.mappers.mapToPresenter
import com.example.presenter.models.Company
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val dispatcher: DispatcherProvider,
    private val companyUseCase: CompanyUseCase
) : AndroidViewModel(context as Application) {

    private val _company = MutableLiveData<Company>()
    val company = _company as LiveData<Company>

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading as LiveData<Boolean>

    fun getMessage() = "Hello World !"

    fun getCompany(id: String) {
        if (_loading.value == true)
            return
        viewModelScope.launch {
            _loading.value = true
            try {
                withContext(dispatcher.io) {
                    // simulate long running operation
                    delay(2_000)
                    companyUseCase.getCompanyInfo(id)
                }.also {
                    _company.value = it.mapToPresenter()
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "getCompany($id) with error", e)
            } finally {
                _loading.value = false
            }
        }
    }

}
