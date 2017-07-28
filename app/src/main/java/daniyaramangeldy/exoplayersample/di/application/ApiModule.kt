package daniyaramangeldy.exoplayersample.di.application

import dagger.Module
import dagger.Provides
import daniyaramangeldy.exoplayersample.data.source.network.API
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by marsstudio on 28.07.17.
 */


@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) = retrofit.create(API::class.java)

}