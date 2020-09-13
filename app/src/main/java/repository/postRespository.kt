package repository

import Models.post
import retrofit2.Response

class postRespository {
    suspend fun getpost(): Response<List<post>> = withContext(Dispatchers.IO + NonCancellable) {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getpost()
        return@withContext response
    }
}
