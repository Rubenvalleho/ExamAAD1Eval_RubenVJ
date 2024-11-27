package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.gson.Gson
import edu.iesam.examaad1eval.db.ExamDataBase
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.GamesLocalDataBase
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        //executeExercise2() //No he encontrado solucion al problema en este ejercicio, doy por hecho que es algo del converter
    }

    private fun executeExercise1() {
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente

        val ex1DataRepository =
            Ex1DataRepository(MockEx1RemoteDataSource(), Ex1XmlLocalDataSource(this, Gson()))

        ex1DataRepository.getUsers().toString()
        ex1DataRepository.getItems().toString()
        ex1DataRepository.getServices().toString()

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
            val db = Room.databaseBuilder(
                applicationContext,
                ExamDataBase::class.java, "database-name"
            ).build()

            val gamesDao = db.gamesDao()

            val gamesDataRepository = Ex2DataRepository(
                MockEx2RemoteDataSource(),
                GamesLocalDataBase(gamesDao)
            )

            gamesDataRepository.saveGames()
            gamesDataRepository.getGames()

        }
    }
}