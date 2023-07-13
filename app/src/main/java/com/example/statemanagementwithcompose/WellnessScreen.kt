package com.example.statemanagementwithcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.statemanagementwithcompose.counters.StatefulCounter
import com.example.statemanagementwithcompose.wellnesstask.WellnessTasksList
import androidx.lifecycle.viewmodel.compose.viewModel

// 画面全体を表す
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    // コンポジションに保存
    // WaterCounter(modifier)
    // Composeの状態を復元
    // WaterCounterV2(modifier)
    // 状態ホイスティング
    // StatefulCounter(modifier)
    // リストを操作する
    Column(modifier = modifier) {
        StatefulCounter()

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChanged(task, checked)
            }
        )
    }
}

@Preview
@Composable
fun PreviewWellnessScreen() {
    WellnessScreen()
}