package com.example.statemanagementwithcompose.counters

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    var juiceCount by remember { mutableStateOf(0) }
    Row {
        StatelessCounter(count = count, onIncrement = { count++ }, modifier)
        StatelessCounter(count = juiceCount, onIncrement = { juiceCount++ })
    }
}

@Preview
@Composable
fun PreviewStatefulCounter() {
    StatefulCounter()
}