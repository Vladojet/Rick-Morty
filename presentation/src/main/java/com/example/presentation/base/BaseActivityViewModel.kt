package com.example.presentation.base

import android.app.Application

open class BaseActivityViewModel<T : BaseState>(
    state: T,
    app: Application
) : BaseViewModel<T>(state, app)