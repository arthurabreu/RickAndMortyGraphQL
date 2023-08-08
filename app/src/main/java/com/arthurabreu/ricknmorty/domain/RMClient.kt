package com.arthurabreu.ricknmorty.domain

import com.arthurabreu.ricknmorty.data.UICharacters

interface RMClient {

    suspend fun getCharacters(): List<UICharacters>
}