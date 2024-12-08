package edu.iesam.examaad1eval.core.modules

import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("edu.iesam.examaad1eval")
class AppModule {

    @Single
    fun provideGson(): Gson {
        return Gson()
    }
}