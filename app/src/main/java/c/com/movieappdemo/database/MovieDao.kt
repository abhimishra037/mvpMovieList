package c.com.movieappdemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import c.com.movieappdemo.model.Movies

@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovies(movieEntity: List<Movies>)

    @Query("SELECT * FROM movieList")
    fun getMovies():List<Movies>
}