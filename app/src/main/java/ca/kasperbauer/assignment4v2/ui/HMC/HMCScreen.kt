package ca.kasperbauer.assignment4v2.ui.HMC

//import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.State
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import ca.kasperbauer.assignment4v2.ui.common.BottomBar
import ca.kasperbauer.assignment4v2.ui.common.TopAppBar
import ca.kasperbauer.assignment4v2.ui.navigation.HMCDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RollerScreen(
    viewModel: HMCViewModel,
    onTabPressed: (String) -> Unit,
    modifier: Modifier = Modifier
) {

//    val state: State<RollerUiState> = viewModel.rollerUiState
//    val rollerUiState: RollerUiState = state.value
//    val numberOfDice: Int by viewModel.numberOfDice.collectAsState()

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = stringResource(HMCDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomBar(
                currentRoute = HMCDestination.route,
                onTabPressed = onTabPressed
            )
        }
    ) { innerPadding ->
//        when (rollerUiState) {
//            is RollerUiState.Rolled -> RolledBody(
//                rollData = rollerUiState.rollData,
//                trafCounts = rollerUiState.trafCounts,
//                date = rollerUiState.date,
//                numberOfDice = numberOfDice,
//                onRoll = viewModel::onRoll,
//                onReset = viewModel::onReset,
//                modifier = modifier.padding(innerPadding)
//            )
//        }
    }
}