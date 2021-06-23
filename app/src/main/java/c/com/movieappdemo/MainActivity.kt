package c.com.movieappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.com.movieappdemo.contact.MovieListContact
import c.com.movieappdemo.database.AppDataBase
import c.com.movieappdemo.model.Movies
import c.com.movieappdemo.presnter.MoviePresenter
import c.com.view.MovieListAdapter

class MainActivity : AppCompatActivity(), MovieListContact.View {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieListArray: ArrayList<Movies>
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: MovieListAdapter
    private var db: AppDataBase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById<RecyclerView>(R.id.rvMovieList)
        progressBar=findViewById<ProgressBar>(R.id.progressBar)
        movieListArray= ArrayList<Movies>()
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)

        db = AppDataBase.getAppDataBase(this)

        val movieListPresenter = MoviePresenter(this,db)
        movieListPresenter.requestDataFromServer()

    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE

    }

    override fun setDataRecyclerView(movieList: List<Movies>) {
        movieListArray.addAll(movieList)
        adapter = MovieListAdapter(movieListArray)
        recyclerView.adapter = adapter
    }
}