package database

import Models.post
import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities= arrayOf(post::class))
class postAppDatabase {
    abstract fun postDao():postsDao

    companion object{
        private var dbInstance:postAppDatabase?=null

        fun getdbInstance(context: Context):postAppDatabase{
            if (dbInstance==null){
                dbInstance= Room.databaseBuilder(context,postAppDatabase::class.java name:postapp)
            }
            return dbInstance as postAppDatabase
        }
    }
}

























