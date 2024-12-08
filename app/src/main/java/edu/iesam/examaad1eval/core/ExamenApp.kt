package edu.iesam.examaad1eval.core

import android.app.Application
import edu.iesam.examaad1eval.core.modules.AppModule
import edu.iesam.examaad1eval.core.modules.LocalModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ExamenApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ExamenApp)
            modules(AppModule().module, LocalModule().module)
        }
    }
}