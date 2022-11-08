package com.jelly.lib

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

object DisplayHelper {
    /**
     * 屏幕密度,系统源码注释不推荐使用
     */
    val DENSITY = Resources.getSystem().displayMetrics.density

    private val sHasCamera: Boolean? = null

    /**
     * 获取 DisplayMetrics
     *
     * @return
     */
    fun getDisplayMetrics(context: Context): DisplayMetrics? {
        return context.resources.displayMetrics
    }

    /**
     * 把以 dp 为单位的值，转化为以 px 为单位的值
     *
     * @param dpValue 以 dp 为单位的值
     * @return px value
     */
    fun dpToPx(dpValue: Int): Int {
        return (dpValue * DENSITY + 0.5f).toInt()
    }

    /**
     * 把以 px 为单位的值，转化为以 dp 为单位的值
     *
     * @param pxValue 以 px 为单位的值
     * @return dp值
     */
    fun pxToDp(pxValue: Float): Int {
        return (pxValue / DENSITY + 0.5f).toInt()
    }

    fun getDensity(context: Context): Float {
        return context.resources.displayMetrics.density
    }

    fun getFontDensity(context: Context): Float {
        return context.resources.displayMetrics.scaledDensity
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    fun getScreenWidth(context: Context): Int {
        return getDisplayMetrics(context)?.widthPixels ?: 0
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    fun getScreenHeight(context: Context): Int {
        return getDisplayMetrics(context)?.heightPixels ?: 0
    }


}