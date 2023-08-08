package com.arthurabreu.ricknmorty.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthurabreu.ricknmorty.data.characters.CharactersState
import com.arthurabreu.ricknmorty.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCharacters()
        }
    }

    private suspend fun getCharacters() {
        _state.update {
            it.copy(isLoading = true)
        }
        // characters will suspend for the time it takes to get the API info and
        // then isLoading is set to false
        _state.update {
            it.copy(
                characters = getCharactersUseCase.execute(),
                isLoading = false
            )
        }
    }
}