package com.example.statemanagementwithcompose

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.statemanagementwithcompose.wellnesstask.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChanged(item: WellnessTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

    private fun getWellnessTasks() = List(30) { i ->
        WellnessTask(i, "Task # $i")
    }
}