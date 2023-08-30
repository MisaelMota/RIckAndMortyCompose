package com.example.rickmortycompose.ui.components

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Theaters
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Theaters
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rickmortycompose.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottonBar(navController: NavController,
              ) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination = navBackStackEntry?.destination?.route ?: AppScreens.MainScreen.route
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    Log.d("Route","Route: ${item.route}")
                    //navController.navigate(item.route)
                    navigateTo(item.route, navController as NavHostController)
                },
                label = { Text(text = item.title)},
                alwaysShowLabel = false,
                icon = {
                    BadgedBox(
                        badge ={
                            if (item.badgeCount != null)
                            {
                                Badge{
                                    Text(text = item.badgeCount.toString())
                                }
                            }else if(item.hasNews){
                                Badge()
                            }

                        }
                    ) {
                            Icon(
                                imageVector =
                                if (index == selectedItemIndex)
                                { item.selectedIcon}
                                else
                                {item.unSelectedIcon},
                                contentDescription = item.title
                            )
                    }
                }
            )
        }
    }
}


    fun navigateTo(destination:String,navController: NavHostController) {
        navController.navigate(destination) {
            popUpTo(AppScreens.MainScreen.route) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }



data class BottonNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val route: String

)

val items = listOf(
    BottonNavigationItem(
        title = "Characters",
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        hasNews = false,
        route = "CharactersScreen"
    ),
    BottonNavigationItem(
        title = "Episodes",
        selectedIcon = Icons.Filled.Theaters,
        unSelectedIcon = Icons.Outlined.Theaters,
        hasNews = false,
        route = "EpisodesScreen"
    ),
    BottonNavigationItem(
        title = "User",
        selectedIcon = Icons.Filled.AccountBox,
        unSelectedIcon = Icons.Outlined.AccountBox,
        hasNews = false,
        route = "UserScreen"
    )
)
