package com.jelly

import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jelly.lib.JellySystemUiHelper

class MainActivity : AppCompatActivity() {

    private lateinit var rootView: RelativeLayout
    private lateinit var txtTop: TextView
    private lateinit var txtBottom: TextView
    private lateinit var btnTest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_systemui_helper)

        rootView = findViewById(R.id.relativelayout_main_root)
        txtTop = findViewById(R.id.txt_top)
        txtBottom = findViewById(R.id.txt_bottom)
        btnTest = findViewById(R.id.btn_test)

    }
}