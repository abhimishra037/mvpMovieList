package c.com.movieappdemo.network

import c.com.movieappdemo.model.MoviesListResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


interface ApiInterface {

    @GET("movie/now_playing?api_key=3c9130ad7ad96c784590993123515dc2&language=en-US&page=1")
    fun callLoginWebservice(): Call<MoviesListResponse>

    companion object {
        private var gson = GsonBuilder()
            .setLenient()
            .create()!!
        var BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): ApiInterface {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(1, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)
                .build()
            val retrofit = Retrofit.Builder()
                //   .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}




