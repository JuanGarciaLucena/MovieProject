package com.juanlucena.movieproject.domain.usecase

import com.juanlucena.movieproject.data.database.entity.MovieEntity
import com.juanlucena.movieproject.data.repository.MovieRepository
import com.juanlucena.movieproject.domain.model.toDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class MovieUseCaseTest{

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository
    private lateinit var movieUseCase: MovieUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        movieUseCase = MovieUseCase(movieRepository)
    }

    @Test
    fun `When database is not empty return a movie list`() = runBlocking {

        val movieList = listOf(
            MovieEntity(
                id = "1",
                title = "random movie",
                originalTitle = "pelicula aleatoria",
                originalTitleRomanised = "random movie",
                image = "picture",
                movieBanner = "movieBanner",
                description = "description",
                director = "director",
                producer = "producer",
                releaseDate = 1984,
                runningTime = 37,
                rtScore = 10,
                people = listOf("person"),
                species = listOf("specie"),
                locations = listOf("location"),
                vehicles = listOf("vehicle"),
                url = "url",
            )
        )

        //Given
        coEvery { movieRepository.getAllMoviesFromDatabase() } returns movieList

        //When
        movieUseCase.getAllMovies()

        //When
        coVerify (exactly = 1) { movieRepository.getAllMoviesFromDatabase() }
    }

    @Test
    fun `When we have two movies and we delete one of them only one movie remain`() = runBlocking {
        val movieList = listOf(
            MovieEntity(
                id = "1",
                title = "random movie",
                originalTitle = "pelicula aleatoria",
                originalTitleRomanised = "random movie",
                image = "picture",
                movieBanner = "movieBanner",
                description = "description",
                director = "director",
                producer = "producer",
                releaseDate = 1984,
                runningTime = 37,
                rtScore = 10,
                people = listOf("person"),
                species = listOf("specie"),
                locations = listOf("location"),
                vehicles = listOf("vehicle"),
                url = "url",
            ),
            MovieEntity(
                id = "2",
                title = "random movie 2",
                originalTitle = "pelicula aleatoria 2",
                originalTitleRomanised = "random movie 2",
                image = "picture2",
                movieBanner = "movieBanner2",
                description = "description2",
                director = "director2",
                producer = "producer2",
                releaseDate = 1984,
                runningTime = 37,
                rtScore = 10,
                people = listOf("person2"),
                species = listOf("specie2"),
                locations = listOf("location2"),
                vehicles = listOf("vehicle2"),
                url = "url2",
            )
        )

        //Given
        coEvery { movieRepository.getAllMoviesFromDatabase() } returns movieList

        //When
        movieUseCase.deleteMovieFromDatabase(movieList[0].toDomain())
        movieUseCase.getAllMovies()

        //When
        coVerify (exactly = 1) { movieRepository.getAllMoviesFromDatabase() }
    }

    @Test
    fun `insert movie in the database`() = runBlocking {

        val movieList = listOf(
            MovieEntity(
                id = "1",
                title = "random movie",
                originalTitle = "pelicula aleatoria",
                originalTitleRomanised = "random movie",
                image = "picture",
                movieBanner = "movieBanner",
                description = "description",
                director = "director",
                producer = "producer",
                releaseDate = 1984,
                runningTime = 37,
                rtScore = 10,
                people = listOf("person"),
                species = listOf("specie"),
                locations = listOf("location"),
                vehicles = listOf("vehicle"),
                url = "url",
            )
        )

        //Given
        coEvery { movieRepository.getAllMoviesFromDatabase() } returns emptyList()

        //When
        movieRepository.insertAllMovies(movieList)

        //When
        coVerify(exactly = 1) { movieRepository.insertAllMovies(movieList) }
    }
}