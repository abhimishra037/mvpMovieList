package c.com.movieappdemo.contact

import c.com.movieappdemo.model.Movies

interface MovieListContact {

    interface Model{

        interface OnFinishedListener{
            fun onFinished(movieList: List<Movies>)
            fun onFailure(t:Throwable)
        }

        fun getMoviesList(onFinishedListener: OnFinishedListener)
    }

    interface View {

        fun showProgress()
        fun hideProgress()
        fun setDataRecyclerView(movieList: List<Movies>)
    }
    interface Presenter{
        fun onDestroy()
        fun requestDataFromServer()
    }
}