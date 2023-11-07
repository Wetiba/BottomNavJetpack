package com.erick.bottomnavapp.ui.theme.screens.bottonnav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen(navController: NavHostController) {
    // Define your items for the bottom navigation
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile,
        BottomNavItem.Settings
    )
    var selectedItem by remember { mutableStateOf(BottomNavItem.Home) }




            NavigationBar(
                modifier = Modifier.fillMaxSize(),


                ) {
                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        label = { Text(text = item.title) },
                        selected = selectedItem == item,
                        onClick = {
                            selectedItem = item as BottomNavItem.Home
                            navController.navigate(item.route)
                        }
                    )
                }
                  }


}

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val title: String

) {
    object Home : BottomNavItem("home", Icons.Default.Home,"Home" )
    object Profile : BottomNavItem("profile", Icons.Default.Person,"Person")
    object Settings : BottomNavItem("settings", Icons.Default.Settings,"Settings")
}

@Preview
@Composable
fun simplebottom() {
    BottomNavScreen(rememberNavController())
}