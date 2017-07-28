package daniyaramangeldy.exoplayersample.di.microphone

import dagger.Module
import dagger.Provides
import daniyaramangeldy.exoplayersample.business.microphone.MicrophoneInteractor
import daniyaramangeldy.exoplayersample.business.microphone.MicrophoneInteractorImpl
import daniyaramangeldy.exoplayersample.data.repository.microphone.MicrophoneRepository
import daniyaramangeldy.exoplayersample.data.repository.microphone.MicrophoneRepositoryImpl
import daniyaramangeldy.exoplayersample.data.source.network.API

@Module
class MicrophoneModule {

    @Provides
    @MicrophoneScope
    fun provideMicrophoneInteractor(microphoneRepository: MicrophoneRepository): MicrophoneInteractor {
        return MicrophoneInteractorImpl(microphoneRepository)
    }


    @Provides
    @MicrophoneScope
    fun provideMicrophoneRepository(api: API): MicrophoneRepository {
        return MicrophoneRepositoryImpl(api)
    }

}