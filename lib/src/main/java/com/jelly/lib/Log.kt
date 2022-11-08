package com.jelly.lib

import android.content.Context
import android.util.Log
import java.lang.ref.WeakReference

object Log {

    interface LogDelegate {
        fun e(tag: String, msg: String, vararg obj: Any)
        fun w(tag: String, msg: String, vararg obj: Any)
        fun i(tag: String, msg: String, vararg obj: Any)
        fun d(tag: String, msg: String, vararg obj: Any)
        fun printErrStackTrace(tag: String, tr: Throwable, format: String, vararg obj: Any)
    }

    class DebugLog(context: Context) : LogDelegate {

        private var logContext: WeakReference<Context>

        init {
            logContext = WeakReference(context)
        }

        override fun e(tag: String, msg: String, vararg obj: Any) {
            val context = logContext.get()
            context?.let {
                if (AppHelper.isDebug(context)) {
                    Log.e(tag, msg)
                }
            }
        }

        override fun w(tag: String, msg: String, vararg obj: Any) {
            val context = logContext.get()
            context?.let {
                if (AppHelper.isDebug(context)) {
                    Log.w(tag, msg)
                }
            }
        }

        override fun i(tag: String, msg: String, vararg obj: Any) {
            val context = logContext.get()
            context?.let {
                if (AppHelper.isDebug(context)) {
                    Log.i(tag, msg)
                }
            }
        }

        override fun d(tag: String, msg: String, vararg obj: Any) {
            val context = logContext.get()
            context?.let {
                if (AppHelper.isDebug(context)) {
                    Log.d(tag, msg)
                }
            }
        }

        override fun printErrStackTrace(
            tag: String,
            tr: Throwable,
            format: String,
            vararg obj: Any
        ) {

        }
    }

    private var logDelegete: LogDelegate? = null

    fun init(delegete: LogDelegate) {
        logDelegete = delegete
    }

    fun e(tag: String, msg: String, vararg obj: Any) {
        logDelegete?.e(tag, msg, obj)
    }

    fun w(tag: String, msg: String, vararg obj: Any) {
        logDelegete?.w(tag, msg, obj)
    }

    fun i(tag: String, msg: String, vararg obj: Any) {
        logDelegete?.i(tag, msg, obj)
    }

    fun d(tag: String, msg: String, vararg obj: Any) {
        logDelegete?.d(tag, msg, obj)
    }

    fun printErrStackTrace(tag: String, tr: Throwable, format: String, vararg obj: Any) {
        logDelegete?.printErrStackTrace(tag, tr, format, *obj)
    }


}