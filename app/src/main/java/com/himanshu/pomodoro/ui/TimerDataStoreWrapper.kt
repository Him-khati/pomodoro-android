package com.himanshu.pomodoro.ui

import TimerType
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class TimerDataStoreWrapper(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private const val dataStoreKey = "tabSelected"
    }

    fun getTabSelectedAsFlow(): Flow<TimerType> {

        dataStore.data[]

        throw Exception()
    }

    fun tabChanged(
        tab : TimerType
    ){

    }
}