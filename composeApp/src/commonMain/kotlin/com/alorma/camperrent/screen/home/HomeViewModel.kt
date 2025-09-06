package com.alorma.camperrent.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.camperrent.data.TodoDao
import com.alorma.camperrent.data.TodoEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
  private val todoDao: TodoDao,
) : ViewModel() {

  val uiState: StateFlow<HomeState> = todoDao
    .getAllAsFlow()
    .map { items ->
      HomeState.Loaded(
        count = items.size,
        items = items,
      )
    }.stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(5000),
      initialValue = HomeState.Loading,
    )

  fun create() = viewModelScope.launch {
    todoDao.insert(
      TodoEntity(
        title = "Test",
        content = "Test content",
      )
    )
  }

}