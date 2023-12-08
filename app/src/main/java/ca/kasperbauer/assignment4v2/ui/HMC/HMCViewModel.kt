package ca.kasperbauer.assignment4v2.ui.HMC

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

//import ca.kasperbauer.assignment4v2.domain.toUpdatedBy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class HMCViewModel @Inject constructor(
//    private val getRollDataUseCase: GetRollDataUseCase,
//    private val saveRollToTrafUseCase: SaveRollToTrafUseCase,
//    private val resetTrafUseCase: ResetTrafUseCase,
//    private val getRollerSavedStateUseCase: GetRollerSavedStateUseCase,
//    getNumberOfDiceUseCase: GetNumberOfDiceUseCase
) : ViewModel() {

//    private val _rollerUiState: MutableState<RollerUiState> = mutableStateOf(RollerUiState.Loading)
//    val rollerUiState: State<RollerUiState> = _rollerUiState

//    val numberOfDice: StateFlow<Int> = getNumberOfDiceUseCase()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = 3
//        )

//    init {
//        viewModelScope.launch {
//            val rollerSavedState: RollerSavedState = getRollerSavedStateUseCase()
//            if (rollerSavedState is RollerSavedState.Saved) {
//                val trafItem: TrafItem = rollerSavedState.trafItem
//                val trafCounts: TrafCounts = rollerSavedState.trafCounts
//                _rollerUiState.value = RollerUiState.Rolled(
//                    rollData = trafItem.rollData,
//                    trafCounts = trafCounts,
//                    date = trafItem.date,
//                )
//            } else {
//                _rollerUiState.value = RollerUiState.NotRolled
//            }
//        }
//    }


//    fun onReset() = viewModelScope.launch {
//        resetTrafUseCase()
//        _rollerUiState.value = RollerUiState.NotRolled
//    }

}

