package c.com.movieappdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoviesListResponse {

    @SerializedName("page")
    @Expose
    private var page: Int? = null

    @SerializedName("results")
    @Expose
    private var results: List<Movies?>? = null

    fun getPage(): Int? {
        return page
    }

    fun setPage(page: Int?) {
        this.page = page
    }

    fun getResults(): List<Movies?>? {
        return results
    }

    fun setResults(results: List<Movies?>?) {
        this.results = results
    }
}