package com.alorma.camperrent

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
  isSystemInDark: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colorScheme = if (isSystemInDark) {
      getPlatform().getDarkColorScheme()
    } else {
      getPlatform().getLightColorScheme()
    },
    content = content,
  )
}