package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.GameLocalDataBase
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game
import org.koin.core.annotation.Single

@Single
class Ex2DataRepository(
    private val localData: GameLocalDataBase,
    private val remoteData: MockEx2RemoteDataSource
) : Ex2Repository {

    companion object {
        private const val MAX_CACHE_GAMES = 5
    }

        override suspend fun getGames(): List<Game> {
        val cachedGames = localData.getAllGames().take(MAX_CACHE_GAMES)
        val remoteGames = remoteData.getGames()
        val allGames = (cachedGames + remoteGames).distinctBy {
            it.id
        }

        val updateCache = allGames.take(MAX_CACHE_GAMES)
        localData.saveGames(updateCache)

        return allGames
    }

}