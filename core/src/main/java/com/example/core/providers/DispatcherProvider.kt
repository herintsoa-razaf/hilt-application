package com.example.core.providers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

class DispatcherProvider @Inject constructor() {

    val ui: CoroutineDispatcher
        get() = Main

    val io: CoroutineDispatcher
        get() = IO
}
