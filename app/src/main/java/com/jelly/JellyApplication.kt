package com.jelly

import android.app.Application
import android.content.Context
import com.jelly.lib.Log

class JellyApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        Log.init(Log.DebugLog(this))
    }
}