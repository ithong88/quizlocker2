package com.toute.quizlocker

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ScreenOffExActivity : AppCompatActivity() {
    // ScreenOffReceiver 객체
    var screenOffReceiver: ScreenOffReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_off_ex)

        // screenOffReceiver 가 널인 경우에만 새로 생성하고 등록한다.
        if (screenOffReceiver == null) {
            screenOffReceiver = ScreenOffReceiver()
            val intentFilter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(screenOffReceiver, intentFilter)
        }
    }
}