package UI

import Models.postViewModelFactory
import Models.postsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.postapp.R
import repository.postRespository

class MainActivity() : AppCompatActivity(), Parcelable {
    lateinit var postsViewModel: postsViewModel
    lateinit var postsViewModelFactory: postViewModelFactory

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postsViewModelFactory = postViewModelFactory(postRespository())
        postsViewModel =
            postsViewModelFactory(this, postsViewModelFactory).get(postsViewModel::class.java)
        postsViewModel.getpost()
        postsViewModel.postsLiveData.observe(this, Observer { posts ->
            Toast.makeText(baseContext, "${posts.size} posts fetched", Toast.LENGTH_LONG).show()
        })

        postsViewModel.postsFailedLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
