package com.himanshu.pomodoro.ui

import java.time.Duration

sealed interface TimerViewState{

    object InitialDataLoadingState : TimerViewState

    data class ShowTimerScreen(
        val tabsActive : Boolean,
        val tabSelected : Int,
        val timeLeft : Duration,
        val timerRunning : Boolean
    ) : TimerViewState

}
