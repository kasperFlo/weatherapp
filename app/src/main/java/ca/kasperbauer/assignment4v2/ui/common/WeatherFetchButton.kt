package ca.kasperbauer.assignment4v2.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherFetchButton(
    isLoading: Boolean,
    onFetchClicked: () -> Unit
) {
    Button(
        onClick = { onFetchClicked() },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(text = if (isLoading) "Loading..." else "Fetch Weather")
    }
}