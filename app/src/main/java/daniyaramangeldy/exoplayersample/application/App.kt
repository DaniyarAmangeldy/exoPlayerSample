package daniyaramangeldy.exoplayersample.application

import android.app.Application
import cafe.adriel.androidaudioconverter.AndroidAudioConverter
import cafe.adriel.androidaudioconverter.callback.ILoadCallback
import daniyaramangeldy.exoplayersample.di.application.AppComponent
import daniyaramangeldy.exoplayersample.di.application.AppModule
import daniyaramangeldy.exoplayersample.di.application.DaggerAppComponent
import java.lang.Exception

/**
 * Created by marsstudio on 28.07.17.
 */
class App: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        loadMpeg()
    }

    private fun loadMpeg() = AndroidAudioConverter.load(this,object: ILoadCallback{
            override fun onFailure(p0: Exception?) {}
            override fun onSuccess() {}
        })

}