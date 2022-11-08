package com.jelly.lib

import android.content.Context
import android.content.pm.ApplicationInfo


/**
 * app 状态相关方法
 */
object AppHelper {

    fun isDebug(context: Context): Boolean {
        try {
            val info = context.applicationInfo
            return info.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
        } catch (e: Exception) {
            return false
        }
    }
}