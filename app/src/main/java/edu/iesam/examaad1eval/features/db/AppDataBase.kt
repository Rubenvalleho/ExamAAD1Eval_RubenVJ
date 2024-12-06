package edu.iesam.examaad1eval.features.db

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.examaad1eval.features.ex2.data.local.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

}