package edu.iesam.examaad1eval.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}