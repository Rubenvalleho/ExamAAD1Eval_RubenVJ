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
        suspend override fun getGames(): List<Game> {
        val gamesFromLocal = localData.getAllGames()
        if (gamesFromLocal.isEmpty()) {
            val gamesFromRemote = remoteData.getGames()
            localData.saveGames(gamesFromRemote)
            return gamesFromRemote
        } else {
            return gamesFromLocal
        }
    }

}