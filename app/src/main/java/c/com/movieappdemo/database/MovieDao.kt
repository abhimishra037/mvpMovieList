package c.com.movieappdemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovies(movieEntity: MovieEntity)

    @Query("SELECT * FROM movieList")
    fun getMovies():List<MovieEntity>
}