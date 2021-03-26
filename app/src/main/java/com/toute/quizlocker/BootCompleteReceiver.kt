package com.toute.quizlocker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

// BroadcastReceiver 를 상속받는다
class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when {
            intent?.action == Intent.ACTION_BOOT_COMPLETED -> {
                Log.d("quizlocker", "부팅이 완료됨")
                Toast.makeText(context, "퀴즈 잠금화면: 부팅이 완료됨", Toast.LENGTH_LONG).show()
            }
        }
    }
}