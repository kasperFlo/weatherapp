package ca.kasperbauer.assignment4v2.ui.HMC

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import java.util.Date

@Composable
fun RolledBody(

    date: Date,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 40.dp)
            .fillMaxWidth()
    ) {
//        val list: List<Int> = rollData.values
//        DiceImagesRow(list)

//        RollerTimeStamp(date)

    }
}