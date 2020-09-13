package api

import Models.post
import retrofit2.Response
import retrofit2.http.GET

interface api_interface {
@GET("post")
suspend fun getPost(): Response<List<post>>
}
