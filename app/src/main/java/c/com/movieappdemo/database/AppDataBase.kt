package c.com.movieappdemo.database

import androidx.room.Room
import androidx.room.Database
import androidx.room.Room.databaseBuilder

import androidx.room.RoomDatabase


@Database(entities = [MovieEntity::class],version = 1)
abstract class AppDataBase : RoomDatabase() {

    private var instance: AppDataBase? = null

    abstract fun movieDao(): MovieDao?


}