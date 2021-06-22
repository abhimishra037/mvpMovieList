package c.com.movieappdemo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity (tableName = "movieList")
class MovieEntity {


    private var posterPath: String? = null
    private var adult: Boolean? = null
    private var overview: String? = null
    private var releaseDate: String? = null
    private var genreIds: List<Int?>? = null

    @PrimaryKey
    private var id: Int? = null
    private var originalTitle: String? = null
    private var originalLanguage: String? = null
    private var title: String? = null
    private var backdropPath: String? = null
    private var popularity: Double? = null
    private var voteCount: Int? = null
    private var video: Boolean? = null
    private var voteAverage: Double? = null

}