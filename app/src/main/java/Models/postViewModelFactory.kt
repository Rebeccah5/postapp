package Models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import repository.postRespository

class postViewModelFactory(private val postsRepository: postRespository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(postsViewModel::class.java)){
            return postsViewModel(postRespository) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}