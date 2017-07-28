package daniyaramangeldy.exoplayersample.di.application

import android.content.Context
import cafe.adriel.androidaudioconverter.AndroidAudioConverter
import dagger.Module
import dagger.Provides
import daniyaramangeldy.exoplayersample.application.App
import javax.inject.Singleton

/**
 * Created by marsstudio on 28.07.17.
 */

@Module
class AppModule(val app: App) {


    @Provides
    @Singleton
    fun provideContext(): Context {
        return app.applicationContext
    }

}