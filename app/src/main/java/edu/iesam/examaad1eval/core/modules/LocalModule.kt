package edu.iesam.examaad1eval.core.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.iesam.examaad1eval.core.db.AppDataBase
import edu.iesam.examaad1eval.features.ex2.data.local.GameDao
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDatabase(context: Context): AppDataBase {
        val db = Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "examen_db"
        )
        return db.build()
    }

    @Single
    fun provideGameDao(dataBase: AppDataBase): GameDao {
        return dataBase.gameDao()
    }
}