package com.example.core.providers

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

class DispatcherProvider @Inject constructor() {

    fun ui() = Main

    fun io() = IO
}
