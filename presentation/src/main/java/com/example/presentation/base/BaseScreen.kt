package com.example.presentation.base

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


abstract class BaseScreen {

    abstract val route: String
    abstract val params: List<String>

    @get:StringRes
    abstract val title: Int?
    abstract val showTopBar: Boolean

    fun getRouteWithParams(vararg values: String): String {
        var parameters = ""
        params.forEachIndexed { index, s ->
            val separator = if (index == 0) "?" else "&"
            val value = values.getOrNull(index) ?: "{$s}"
            parameters += "$separator$s=$value"
        }
        return route + parameters
    }

    companion object {
        @Composable
        fun ProgressBar() {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}