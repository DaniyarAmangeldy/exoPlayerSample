package daniyaramangeldy.exoplayersample.di.application

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import daniyaramangeldy.exoplayersample.data.source.network.API
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by marsstudio on 28.07.17.
 */

@Module
class NetworkModule {
    private val BASE_URL = "http://google.com"
    private val TIMEOUT_TIME = 15L

    @Provides
    @Singleton
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder
                .baseUrl(BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(gson: Gson, client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
                .build()

    }

    @Provides
    @Singleton
    fun provideConverter(): Gson {
        return GsonBuilder().create()
    }
}