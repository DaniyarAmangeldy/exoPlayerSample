package daniyaramangeldy.exoplayersample.application

import android.app.Application
import daniyaramangeldy.exoplayersample.di.application.AppComponent
import daniyaramangeldy.exoplayersample.di.application.AppModule
import daniyaramangeldy.exoplayersample.di.application.DaggerAppComponent

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
    }
}