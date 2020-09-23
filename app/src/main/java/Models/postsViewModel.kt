package Models

import androidx.lifecycle.MutableLiveData
import repository.postRespository

class postsViewModel {
    var postsLiveData = MutableLiveData<List<post>>()
    var postsFailedLiveData = MutableLiveData<String>()

    fun getpost() {
        viewModelScope.launch {
            val response = postRespository.getpost()
            if (response.isSuccessful) {
                postsLiveData.postValue(response.body())
            } else {
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun getDBpost(){
        postLiveData=postRespository.get
    }
}
