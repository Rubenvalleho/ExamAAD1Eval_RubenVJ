package edu.iesam.examaad1eval.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.GamesDao
import edu.iesam.examaad1eval.features.ex2.data.local.GamesEntity

@TypeConverters(Converters::class)
@Database(entities = [GamesEntity::class], version = 1)
abstract class ExamDataBase : RoomDatabase() {
    abstract fun gamesDao(): GamesDao
}