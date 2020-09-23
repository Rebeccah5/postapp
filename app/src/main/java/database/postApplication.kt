package database

import android.app.Application
import android.content.Context

class postApplication: Application() {
    override fun OnCreate(){
       super .OnCreate()
        postApplication.appContext=applicationContext
        Stetho.initializeWithDefaults(baseContext)
}
companion object {
    lateinit var appContext: Context
}
}