package com.arthurabreu.ricknmorty.domain

import com.apollographql.apollo3.api.toJson
import com.apollographql.apollo3.ApolloClient
import com.arthurabreu.ricknmorty.data.UICharacters
import com.arthurabreu.ricknmorty.data.UILocation
import com.arthurabreu.ricknmorty.domain.usecases.GetCharactersUseCase
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ApolloRMClientTest {

    /*
     * In this test, we use the coEvery function from MockK to set up a co-routine stub for the
     * getCharacters method. This allows us to control what the method returns when it's called,
     *  and then we can verify that the use case properly calls this method and returns the expected
     * result.
     */
    @Test
    fun `execute should return characters from client`() = runBlocking {
        // Arrange
        val expectedCharacters = listOf(
            UICharacters(
                name = "Luke Skywalker",
                id = "1",
                image = "https://via.placeholder.com/150",
                status = "Alive",
                species = "Human",
                location = UILocation(name = "Tatooine", id = "2"),
                gender = "Male"
            )
        )

        val client: RMClient = mockk()
        coEvery { client.getCharacters() } returns expectedCharacters

        val useCase = GetCharactersUseCase(client)

        // Act
        val actualCharacters = useCase.execute()

        // Assert
        assertEquals(expectedCharacters, actualCharacters)
    }
}