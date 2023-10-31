package com.himanshu.pomodoro.ui

import TimerType
import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class TimerSaveStateHandleWrapper(
    private val savedStateHandle: SavedStateHandle
) {
    companion object {
        const val KEY_TAB_SELECTED = "tabSelected"
    }

    fun getTabSelectedAsFlow(): Flow<TimerType> {
        return savedStateHandle
            .getStateFlow(
                KEY_TAB_SELECTED,
                TimerType.Pomodoro
            ).distinctUntilChanged { old, new -> old == new }
    }

    fun tabChanged(
        tab : TimerType
    ){
        savedStateHandle[KEY_TAB_SELECTED] = tab
    }
}