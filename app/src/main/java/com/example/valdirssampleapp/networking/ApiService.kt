package com.example.valdirssampleapp.networking

import android.content.Context
import co.infinum.retromock.BodyFactory
import co.infinum.retromock.Retromock
import com.example.valdirssampleapp.networking.data.response.sections.SectionResponse
import com.example.valdirssampleapp.sdui.CustomPolymorphicJsonAdapterFactory
import com.example.valdirssampleapp.sdui.SectionTypes
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.io.InputStream
import java.util.concurrent.TimeUnit


// TODO pensar em como passar a implementação para o koin e deletar essa classe
class ApiService(context: Context) {
    var apiEndpoints: SampleNetworking
    var mockSampleNetworking: MockSampleNetworking

    private var retrofit: Retrofit
    var jsonPath = "homeSections.json"

    val BASE_URL = "https://api.example.com"
    val TIMEOUT: Long = 30

    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client1: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val cliente2 = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()

        val moshi = Moshi.Builder()
            .add(
                CustomPolymorphicJsonAdapterFactory.Builder(SectionResponse::class.java, "type")
                    .apply {
                        SectionTypes.SECTION_TYPES.forEach { (label, subtype) ->
                            addSubtype(subtype.java, label)
                        }
                    }
                    .build()
            )
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/rosannaNaomy/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(cliente2)
            .build()

        val assetManager = context.assets
        val retromock: Retromock = Retromock.Builder()
            .retrofit(retrofit)
            .defaultBodyFactory(assetManager::open)
            .addBodyFactory(CustomBuildBodyFactory(context = context, apiService = this))
            .build()

        apiEndpoints = retrofit.create(SampleNetworking::class.java)
        mockSampleNetworking = retromock.create(MockSampleNetworking::class.java)
    }

    fun recreateRetroMock(context: Context, jsonPath: String) {
        this.jsonPath = jsonPath
        val retromock: Retromock = Retromock.Builder()
            .retrofit(retrofit)
            .defaultBodyFactory(context.assets::open)
            .addBodyFactory(CustomBuildBodyFactory(context = context, apiService = this))
            .build()
        mockSampleNetworking = retromock.create(MockSampleNetworking::class.java)
    }
//        val service: MockEndpoints = init().create(MockEndpoints::class.java)
}


internal class CustomBuildBodyFactory(private val context: Context, private val apiService: ApiService) : BodyFactory {
    @Throws(IOException::class)
    override fun create(input: String): InputStream {
        val inputStream = context.assets.open(apiService.jsonPath)
        return inputStream
    }
}