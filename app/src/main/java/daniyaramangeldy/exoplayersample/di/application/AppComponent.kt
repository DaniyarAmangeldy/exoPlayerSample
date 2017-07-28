package daniyaramangeldy.exoplayersample.di.application

import dagger.Component
import daniyaramangeldy.exoplayersample.di.microphone.MicrophoneComponent
import daniyaramangeldy.exoplayersample.di.microphone.MicrophoneModule
import javax.inject.Singleton

/**
 * Created by marsstudio on 28.07.17.
 */
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
@Singleton
interface AppComponent {

    fun plus(module: MicrophoneModule): MicrophoneComponent
}