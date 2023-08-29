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

    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route){
            composable(AppScreens.MainScreen.route){
                RickAndMortyCharacterList(navController,characterViewModel)
            }

            composable(AppScreens.EpisodesScreen.route){
                RickAndMortyEpisodesList(navController)
            }

            composable(AppScreens.UserScreen.route){
                UserSettings(navController)
            }
    }
}