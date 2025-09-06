package com.alorma.camperrent

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun AppTheme(
  isSystemInDark: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {

  val colors = if (isSystemInDark) {
    getPlatform().getDarkColorScheme()
  } else {
    getPlatform().getLightColorScheme()
  }

  MaterialExpressiveTheme(
    colorScheme = colors,
    motionScheme = MotionScheme.expressive(),
    content = content,
  )
}