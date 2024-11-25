package com.example.rickandmorty.main

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.viewModelScope
import com.example.presentation.base.BaseActivityViewModel
import com.example.presentation.base.BaseScreen
import com.example.presentation.utils.getStringResource
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(
    app: Application
) : BaseActivityViewModel<MainActivityState>(MainActivityState(), app) {

    private val _returnNavigationEvent = MutableSharedFlow<Unit>()
    val returnNavigationEvent: SharedFlow<Unit> = _returnNavigationEvent // in case оновлення при поверненні назад

    fun updateCurrentScreen(
        screen: BaseScreen,
        title: String,
        overrideReturnButton: Boolean
    ) {
        updateState { state ->
            state.copy(
                currentScreen = screen,
                title = getStringResource(title.ifEmpty { screen.title }),
                /*action = action,*/
                overrideReturnButton = overrideReturnButton
            )
        }
    }

    fun onReturnPressed(onNavigateUp: () -> Unit) {
        viewModelScope.launch {
            if (uiState.value.overrideReturnButton)
                _returnNavigationEvent.emit(Unit)
            else
                onNavigateUp()
        }
    }

}