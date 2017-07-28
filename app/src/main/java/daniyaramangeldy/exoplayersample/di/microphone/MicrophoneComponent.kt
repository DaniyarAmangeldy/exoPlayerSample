package daniyaramangeldy.exoplayersample.di.microphone

import dagger.Subcomponent
import daniyaramangeldy.exoplayersample.ui.microphone.presenter.MicrophonePresenter
/**
 * Created by marsstudio on 28.07.17.
 */

@Subcomponent(modules = arrayOf(MicrophoneModule::class))
@MicrophoneScope
interface MicrophoneComponent {
    fun inject(presenter: MicrophonePresenter)
}