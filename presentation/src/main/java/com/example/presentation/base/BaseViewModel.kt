package com.example.presentation.base

import android.app.Application
import androidx.compose.material3.SnackbarHostState //todo material3?
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

open class BaseViewModel<T : BaseState>(
    state: T,
    private val context: Application
) : ViewModel(), DefaultLifecycleObserver {
    private val _uiState = MutableStateFlow(state)
    val uiState: StateFlow<T> = _uiState.asStateFlow()

    private val stateLock = Mutex()

    private val _progressBarIsShown = MutableStateFlow(false)
    val progressBarIsShown = _progressBarIsShown.asStateFlow()

    private var snackBarJob: Job? = null
    private val _snackState = MutableStateFlow(SnackbarHostState())
    val snackState = _snackState.asStateFlow()

    fun showProgressBar() {
        _progressBarIsShown.update { true }
    }

    fun hideProgressBar() {
        _progressBarIsShown.update { false }
    }

    fun showSnackBar(message: Any?) {
        snackBarJob = viewModelScope.launch {
            when (message) {
                is String ->
                    snackState.value.showSnackbar(message)
                is Int ->
                    snackState.value.showSnackbar(context.getString(message))
                else -> {}
            }
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        snackBarJob?.cancel()
    }

    protected fun updateState(onUpdate: (T) -> T) {
        _uiState.update {
            onUpdate(it)
        }
    }

    protected suspend fun updateStateSynchronized(onUpdate: (T) -> T) {
        stateLock.withLock {
            updateState(onUpdate)
        }
    }
}