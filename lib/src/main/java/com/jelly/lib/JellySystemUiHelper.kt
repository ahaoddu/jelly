package com.jelly.lib

import android.app.Activity
import android.graphics.Color
import android.view.WindowInsetsController
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE


class JellySystemUiHelper {
    companion object {

        fun fullScreen(activity: Activity) {
            val window = activity.window
            val windowInsetsController =
                WindowCompat.getInsetsController(window, window.decorView)
            windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
            windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
        }


        fun immersiveMode(activity: Activity) {
            val window = activity.window
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.statusBarColor = Color.TRANSPARENT
            window.navigationBarColor = Color.TRANSPARENT
            val windowInsetsController =
                WindowCompat.getInsetsController(window, window.decorView)
            windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        }

        fun immersiveModeSticky(activity: Activity) {
            val window = activity.window
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.statusBarColor = Color.TRANSPARENT
            window.navigationBarColor = Color.TRANSPARENT
            val windowInsetsController =
                WindowCompat.getInsetsController(window, window.decorView)
            windowInsetsController.systemBarsBehavior = BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        }

        fun layoutBelowSystemUi(activity: Activity) {
            val window = activity.window
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }


        fun setStatusbarColor(activity: Activity, @ColorRes color: Int) {
            activity.window.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            activity.window.statusBarColor = ContextCompat.getColor(activity, color)
        }

        fun setNavigationbarColor(activity: Activity, @ColorRes color: Int) {
            activity.window.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            activity.window.navigationBarColor = ContextCompat.getColor(activity, color)
        }

        fun setStatusbarBlackFont(activity: Activity) {
            val window = activity.window
            val windowInsetsController =
                WindowCompat.getInsetsController(window, window.decorView)
            windowInsetsController.isAppearanceLightStatusBars = true
        }

        fun setStatusbarWhiteFont(activity: Activity) {
            val window = activity.window
            val windowInsetsController =
                WindowCompat.getInsetsController(window, window.decorView)
            windowInsetsController.isAppearanceLightStatusBars = false
        }
    }
}


