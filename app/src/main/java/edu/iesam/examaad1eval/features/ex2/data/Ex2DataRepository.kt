package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.GamesLocalDataBase
import edu.iesam.examaad1eval.features.ex2.data.local.toEntity
import edu.iesam.examaad1eval.features.ex2.data.local.toGame
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(
    private val remoteDataSource: MockEx2RemoteDataSource,
    private val localDataSource: GamesLocalDataBase
) : Ex2Repository {
    override fun getGames(): List<Game> {
        val gamesList = ArrayList<Game>()
        val gamesFromLocal = localDataSource.getAll()
        if (gamesFromLocal.isEmpty()) {
            saveGames()
        }
        gamesFromLocal.forEach {
            gamesList.add(it.toGame())
        }
        return gamesList
    }

    override fun saveGames() {
        val gamesFromRemote = remoteDataSource.getGames()
        gamesFromRemote.forEach {
            localDataSource.save(it.toEntity())
        }
    }


}