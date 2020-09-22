package database

import Models.post
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import retrofit2.http.Query

@Dao
interface postsDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun insertPost(post:post)

    @Query("SELECT * FROM post")
    fun getPost():LiveData<List><post>>
}