import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himanshu.pomodoro.ui.TimerSaveStateHandleWrapper
import com.himanshu.pomodoro.ui.TimerViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Duration


class TimerViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    // Constants todo fetch them from data store next time
    private val maxPomodoroTime: Duration = Duration.ofMinutes(25L)
    private val maxShortBreakTime: Duration = Duration.ofMinutes(5L)
    private val maxLongBreakTime: Duration = Duration.ofMinutes(10L)

    private val timerSaveStateHandleWrapper: TimerSaveStateHandleWrapper by lazy {
        TimerSaveStateHandleWrapper(savedStateHandle)
    }

    val viewState: StateFlow<TimerViewState> = MutableStateFlow(
        TimerViewState.InitialDataLoadingState
    )

    private var tabSelected: TimerType = TimerType.Pomodoro //Pomodoro is default one
    private var timeLeft: Duration? = null

    init {
        subscribeToRequiredData()
    }

    private fun subscribeToRequiredData() = viewModelScope.launch {

    }

    private fun timerTypeTabChanged(
        type: TimerType
    ) = timerSaveStateHandleWrapper.tabChanged(
        tab = type
    )

    private fun handleTabChangedOrMaxTimeChanged(
        type: TimerType
    ) {
        this.tabSelected = type
    }
}