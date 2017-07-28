package daniyaramangeldy.exoplayersample.ui.microphone.presenter

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import daniyaramangeldy.exoplayersample.application.App
import daniyaramangeldy.exoplayersample.business.microphone.MicrophoneInteractor
import daniyaramangeldy.exoplayersample.di.microphone.MicrophoneModule
import daniyaramangeldy.exoplayersample.ui.microphone.view.MicrophoneView
import javax.inject.Inject

/**
 * Created by marsstudio on 28.07.17.
 */

@InjectViewState
class MicrophonePresenter: MvpPresenter<MicrophoneView>() {

    @Inject
    lateinit var interactor: MicrophoneInteractor

    init {
        App.appComponent.plus(MicrophoneModule()).inject(this)
    }


    fun startRecord(path: String){
        interactor.startRecord(path)
    }

    fun stopRecord(context: Context){
        interactor.stopRecord(context)
    }

}