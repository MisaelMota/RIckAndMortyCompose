package com.example.rickmortycompose.navigation

import com.example.rickmortycompose.R

sealed class AppScreens(val route:String){
    object DetailCharacterScreen: AppScreens("DetailCharacterScreen/{id}")
}

sealed class AppButtonBarScreens(val route:String, val icon:Int){
    object MainScreen: AppButtonBarScreens("CharacterList",R.drawable.icons8_morty)

    object EpisodesScreen:AppButtonBarScreens("EpisodesList",R.drawable.movie_svgrepo_com)

    object UserScreen:AppButtonBarScreens("UserScreen",R.drawable.personal_account_account_svgrepo_com)

}
