package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game
import org.koin.core.annotation.Single

@Single
class GameLocalDataBase(private val gameDao: GameDao) {

    fun getAllGames(): List<Game> {
        return gameDao.getAllGames().map {
            it.toDomain()
        }
    }

    fun saveGames(games: List<Game>) {
        gameDao.saveAllGames(games.map { it.toEntity() })
    }
}