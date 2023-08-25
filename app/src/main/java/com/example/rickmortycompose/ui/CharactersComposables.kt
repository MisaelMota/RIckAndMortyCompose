package com.example.rickmortycompose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.rickmortycompose.models.Character
import com.example.rickmortycompose.viewmodel.CharacterViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RickAndMortyApp(viewModel: CharacterViewmodel){
    val characters: List<Character> by viewModel.characters.observeAsState(emptyList())



    LaunchedEffect(Unit){
        viewModel.getCharacters()
    }

    Scaffold(
        topBar = {AppBar()},
        content = {CharacterList(characters)}
    )
}

@Composable
fun CharacterList(characters: List<Character>) {
    LazyColumn {
        items(characters) { character ->
            CharacterItem(character)
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = character.name)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Rick and Morty")}
    )
}
