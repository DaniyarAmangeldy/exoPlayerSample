package daniyaramangeldy.exoplayersample.data.repository.microphone

import daniyaramangeldy.exoplayersample.data.source.network.API
import daniyaramangeldy.exoplayersample.di.microphone.MicrophoneScope
import javax.inject.Inject

/**
 * Created by marsstudio on 28.07.17.
 */
@MicrophoneScope
class MicrophoneRepositoryImpl @Inject constructor(val api: API) : MicrophoneRepository {

}