package com.himanshu.pomodoro.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun Timer(
    text : String
) {
    val timerText by remember {
        mutableStateOf(text)
    }



}