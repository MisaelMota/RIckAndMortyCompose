package com.example.rickmortycompose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickmortycompose.ui.components.AppBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RickAndMortyEpisodesList(navController: NavController){
    Scaffold(
        topBar = { AppBar("Episodes") },
        content = {paddingValues ->
            Box(
                modifier = androidx.compose.ui.Modifier
                    .padding(paddingValues)
                    .padding(top = 16.dp)
            ) {
                EpisodesList(navController)

            }
        }
    )
}

@Composable
fun EpisodesList (navController: NavController){
    Text(text = "Episodes Coming...")
}


