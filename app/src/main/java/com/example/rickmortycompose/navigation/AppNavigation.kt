package com.example.rickmortycompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickmortycompose.ui.RickAndMortyCharacterList
import com.example.rickmortycompose.ui.RickAndMortyEpisodesList
import com.example.rickmortycompose.ui.UserSettings
import com.example.rickmortycompose.viewmodel.CharacterViewmodel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val characterViewModel: CharacterViewmodel= viewModel()

    NavHost(navController = navController, startDestination = AppButtonBarScreens.MainScreen.route){
            composable(AppButtonBarScreens.MainScreen.route){
                RickAndMortyCharacterList(navController,characterViewModel)
            }

            composable(AppButtonBarScreens.EpisodesScreen.route){
                RickAndMortyEpisodesList(navController)
            }

            composable(AppButtonBarScreens.UserScreen.route){
                UserSettings(navController)
            }
    }
}