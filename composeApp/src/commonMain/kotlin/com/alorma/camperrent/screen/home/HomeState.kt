package com.alorma.camperrent.screen.home

import com.alorma.camperrent.data.TodoEntity

sealed interface HomeState {
  data object Loading: HomeState
  data class Loaded(
    val count: Int,
    val items: List<TodoEntity>,
  ): HomeState
}