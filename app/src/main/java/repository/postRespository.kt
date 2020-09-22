package repository

import Models.post
import database.postAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.invoke
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.POST

class postRespository {
    suspend fun getpost(): Response<List<post>> = withContext(Dispatchers.IO + NonCancellable) {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getpost()
        response
    }
    suspend fun savepost(postList: List<post>)= withContext((Dispatchers.IO){
        this:CoroutineScope)
        val database=postAppDatabase.getdbInstance(post.appContext)
        postList.forEach{post: post ->
            database.postDao().insertPost(post)
    }
}
