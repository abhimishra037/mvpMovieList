package c.com.movieappdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [MovieEntity::class],version = 1)
abstract class AppDataBase : RoomDatabase() {

    //private var instance: AppDataBase? = null

    abstract fun movieDao(): MovieDao?


    companion object {
        var INSTANCE: AppDataBase? = null

        fun getAppDataBase(context: Context): AppDataBase? {
            if (INSTANCE == null){
                synchronized(AppDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "movieDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

/*
    open fun getAppDatabase(context: Context): AppDataBase? {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "movieList-db"
            )
                .allowMainThreadQueries()
                .build()
        }
        return instance
    }
*/
}