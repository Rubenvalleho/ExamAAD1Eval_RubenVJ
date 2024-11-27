package edu.iesam.examaad1eval.db

import androidx.room.TypeConverter
import edu.iesam.examaad1eval.features.ex2.domain.Player

class Converters {

    @TypeConverter
    fun fromPlayerList(players: List<Player>): String {
        return players.joinToString(",") { it.id }
    }

    @TypeConverter
    fun toPlayerList(playersString: String): List<Player> {
        return playersString.split(",").map { Player(it.get(0).toString(), it.get(1).toString()) }
    }

}