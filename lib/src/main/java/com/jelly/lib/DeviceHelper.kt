package com.jelly.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*


object DeviceHelper {

    private var isTabletChecked = false
    private var isTablet = false

    private val BRAND = Build.BRAND.lowercase()

    private val MEIZUBOARD = arrayOf("m9", "M9", "mx", "MX")

    private fun _isTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >=
                Configuration.SCREENLAYOUT_SIZE_LARGE
    }

    /**
     * 判断是否为平板设备
     */
    fun isTablet(context: Context): Boolean {
        if (isTabletChecked) {
            return isTablet
        }
        isTablet = _isTablet(context)
        isTabletChecked = true
        return isTablet
    }


    fun isXiaomi(): Boolean {
        return Build.MANUFACTURER.lowercase(Locale.getDefault()) == "xiaomi"
    }

    fun isVivo(): Boolean {
        return BRAND.contains("vivo") || BRAND.contains("bbk")
    }

    fun isOppo(): Boolean {
        return BRAND.contains("oppo")
    }

    fun isHuawei(): Boolean {
        return BRAND.contains("huawei") || BRAND.contains(
            "honor"
        )
    }


    private fun isPhone(boards: Array<String>): Boolean {
        val board = Build.BOARD ?: return false
        for (board1 in boards) {
            if (board == board1) {
                return true
            }
        }
        return false
    }

    public fun isMeizu(): Boolean {
        return isPhone(MEIZUBOARD)
    }
}