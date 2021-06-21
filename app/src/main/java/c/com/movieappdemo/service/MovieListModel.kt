package c.com.movieappdemo.service

import android.util.Log
import c.com.movieappdemo.model.Movies
import c.com.movieappdemo.model.MoviesListResponse
import c.com.movieappdemo.network.ApiInterface
import c.com.movieappdemo.contact.MovieListContact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListModel :  MovieListContact.Model{
    private var TAG :String = "MoviesListModel"
    override fun getMoviesList(onFinishedListener: MovieListContact.Model.OnFinishedListener) {

        val apiInterface = ApiInterface.create().callLoginWebservice()

     apiInterface.enqueue(object :Callback<MoviesListResponse>{
         override fun onFailure(call: Call<MoviesListResponse>, t: Throwable) {
             Log.e(TAG,"failur"+t.toString())
             onFinishedListener.onFailure(t)


         }

         override fun onResponse(
             call: Call<MoviesListResponse>,
             response: Response<MoviesListResponse>
         ) {

            var movieList : List<Movies> = response.body()?.getResults() as List<Movies>
             Log.e(TAG,"Number"+movieList.size)
             onFinishedListener.onFinished(movieList)
         }
     })
    }

}