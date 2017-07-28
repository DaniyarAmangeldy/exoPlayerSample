package daniyaramangeldy.exoplayersample.business.microphone

import android.content.Context

/**
 * Created by marsstudio on 28.07.17.
 */
interface MicrophoneInteractor {
    fun stopRecord(context: Context)
    fun startRecord(path: String)

}