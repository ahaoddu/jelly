package com.jelly

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class LauncherActivity : AppCompatActivity() {

    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions: Map<String, Boolean> ->

            var permissionsAllPassed = true
            var permissionsNotAllowed: ArrayList<String> = ArrayList<String>()

            for (entry in permissions.entries) {
                if (entry.value) {
                    //同意权限
                } else {
                    //不同意权限
                    permissionsAllPassed = false
                    permissionsNotAllowed.add(entry.key)
                }
            }

            if (permissionsAllPassed) {
                //这里可以添加 fragment 展示 引导页 广告页 等
                //权限申请都通过了,跳转 MainActivity
                startActivity(Intent(this@LauncherActivity, MainActivity::class.java))
                finish()
            } else {
                // todo 权限申请未通过，弹窗提示用户并给按钮重新申请
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT)
                    .show()
            }

        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0) {
            finish()
            return
        }

        //可以弹窗解释需要的权限和原因后再申请权限
        requestPermissions.launch(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }
}