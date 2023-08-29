package com.example.rickmortycompose.navigation

import com.example.rickmortycompose.R

sealed class AppScreens(val route:String){

    object MainScreen: AppScreens("CharactersScreen")

    object EpisodesScreen:AppScreens("EpisodesScreen")
    object UserScreen:AppScreens("UserScreen")
    object DetailCharacterScreen: AppScreens("DetailCharacterScreen/{id}")
}

