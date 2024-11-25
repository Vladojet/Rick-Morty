package com.example.presentation.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.res.stringResource

@Stable
sealed interface StringResourceHelperI{
    @Composable
    @ReadOnlyComposable
    fun getText(): String
}

sealed class StringResourceHelper: StringResourceHelperI {

    class IntValue(@StringRes val value: Int) : StringResourceHelper() {
        @Composable
        @ReadOnlyComposable
        override fun getText(): String {
            return stringResource(id = value)
        }
    }

    class StringResourceHelperValue(private val value: String) : StringResourceHelper() {
        @Composable
        @ReadOnlyComposable
        override fun getText(): String {
            return value
        }
    }

    class IntValueWithArgs(
        @StringRes val value: Int,
        private val args: Array<String> = arrayOf()
    ) : StringResourceHelper() {
        @Composable
        @ReadOnlyComposable
        override fun getText(): String {
            return stringResource(id = value, *args)
        }
    }

    companion object {
        val defaultValue = StringResourceHelperValue("")
    }
}

fun getStringResource(value: Any?, args: Array<String> = arrayOf()): StringResourceHelperI {
    return when (value) {
        is Int -> {
            if (args.isEmpty()) {
                StringResourceHelper.IntValue(value)
            } else {
                StringResourceHelper.IntValueWithArgs(value, args)
            }
        }
        is String -> StringResourceHelper.StringResourceHelperValue(value)
        else -> StringResourceHelper.StringResourceHelperValue("")
    }
}