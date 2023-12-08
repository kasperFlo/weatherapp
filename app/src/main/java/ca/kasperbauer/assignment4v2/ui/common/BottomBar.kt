package ca.kasperbauer.assignment4v2.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import ca.kasperbauer.assignment4v2.R
import ca.kasperbauer.assignment4v2.ui.navigation.TrafDestination
import ca.kasperbauer.assignment4v2.ui.navigation.HMCDestination
import ca.kasperbauer.assignment4v2.ui.navigation.trafDestination

private data class NavigationItemContent(
    val route: String,
    val icon: ImageVector,
    val text: String
)

@Composable
fun BottomBar(
    currentRoute: String,
    onTabPressed: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            route = HMCDestination.route,
            icon = Icons.Default.Home,
            text = stringResource(id = R.string.HMC)
        ),
        NavigationItemContent(
            route = TrafDestination.route,
            icon = Icons.Default.List,
            text = stringResource(id = R.string.Trafalgar)
        ),
        NavigationItemContent(
            route = trafDestination.route,
            icon = Icons.Default.Settings,
            text = stringResource(id = R.string.traf)
        )
    )

    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = { onTabPressed(navItem.route) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                label = { Text(text = navItem.text) }
            )
        }
    }
}

