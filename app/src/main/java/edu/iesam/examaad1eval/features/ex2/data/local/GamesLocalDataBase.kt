package edu.iesam.examaad1eval.features.ex2.data.local

class GamesLocalDataBase(private val gamesDao: GamesDao) {
    fun getAll(): List<GamesEntity> {
        return gamesDao.getAll()
    }

    fun save(game: GamesEntity) {
        gamesDao.save(game)
    }

}