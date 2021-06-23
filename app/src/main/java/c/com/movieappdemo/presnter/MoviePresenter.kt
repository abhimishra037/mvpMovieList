package c.com.movieappdemo.presnter

import c.com.movieappdemo.model.Movies
import c.com.movieappdemo.contact.MovieListContact
import c.com.movieappdemo.database.AppDataBase
import c.com.movieappdemo.service.MovieListModel

class MoviePresenter(
    private  var movieListView: MovieListContact.View,
    private var appDataBase: AppDataBase?
) : MovieListContact.Presenter, MovieListContact.Model.OnFinishedListener {

    private  val movieListModel= MovieListModel()

    override fun onDestroy() {
        false
    }

    override fun requestDataFromServer() {
        movieListView.showProgress()
        movieListModel.getMoviesList(this,appDataBase)
    }

    override fun onFinished(movieList: List<Movies>) {
        movieListView.setDataRecyclerView(movieList)
        movieListView.hideProgress()
    }

    override fun onFailure(t: Throwable) {
        movieListView.hideProgress()
    }
}