package edu.iesam.examaad1eval.core.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.domain.Player

class Converter {

    @TypeConverter
    fun fromString(playersList: String): List<Player> {
        val listType = object : TypeToken<List<Player>>() {}.type
        return Gson().fromJson(playersList, listType)
    }

    @TypeConverter
    fun toString(playersList: List<Player>): String {
        return Gson().toJson(playersList)
    }
}