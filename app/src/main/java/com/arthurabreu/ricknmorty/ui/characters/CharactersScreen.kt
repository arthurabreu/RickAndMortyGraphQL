package com.arthurabreu.ricknmorty.ui.characters

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arthurabreu.ricknmorty.R
import com.arthurabreu.ricknmorty.data.characters.CharactersState
import com.arthurabreu.ricknmorty.data.characters.UICharacters

@Composable
fun CharactersScreen(
    state: CharactersState,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                // TODO
            }
    ) {
        if(state.isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.characters) { character ->
                    Spacer(modifier = Modifier.height(10.dp))
                    CharacterItem(
                        character = character,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CharacterDivider()
                }
            }
        }
    }
}

@Composable
fun CharacterItem(
    character: UICharacters,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(character.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.user),
            error = painterResource(R.drawable.user),
            contentDescription = stringResource(R.string.character_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .padding(start = 10.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Cyan, CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = character.name.toString(),
                fontSize = 18.sp,
                color = Color.Green,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.width(16.dp))
            CharacterText(info = stringResource(id = R.string.species, character.species.toString()))
            Spacer(modifier = Modifier.width(16.dp))
            CharacterText(info = stringResource(id = R.string.status, character.status.toString()))
            Spacer(modifier = Modifier.width(16.dp))
            CharacterText(
                stringResource(
                    id = R.string.location,
                    character.location?.name
                        ?: stringResource(id = R.string.location_unknown)
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            CharacterText(stringResource(id = R.string.gender, character.gender.toString()))
        }
    }
}

@Composable
fun CharacterText(info: String) {
    val staticText = info.substringBefore(":") + ":"
    val dynamicText = info.substringAfter(":")

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.DarkGray)) {
            append(staticText)
        }
        withStyle(style = SpanStyle(color = Color.Gray)) {
            append(dynamicText)
        }
    }

    Text(
        text = annotatedString,
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace
    )
}

@Composable
fun CharacterDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(modifier = Modifier.weight(0.05f))
        Divider(
            thickness = 1.dp,
            color = Color.Cyan,
            modifier = Modifier
                .weight(0.9f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.weight(0.05f))
    }
}
