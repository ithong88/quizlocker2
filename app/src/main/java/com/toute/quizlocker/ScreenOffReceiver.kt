package com.toute.quizlocker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ScreenOffReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when {
            // 화면이 꺼질 때 오는 브로드캐스트 메세지인 경우 토스트 출력
            intent?.action == Intent.ACTION_SCREEN_OFF -> {
//                Log.d("ScreenOffReceiver", "퀴즈잠금: 화면이 꺼졌습니다.")
//                Toast.makeText(context, "퀴즈잠금: 화면이 꺼졌습니다.", Toast.LENGTH_LONG).show()
                // 화면이 꺼지면 QuizLockerActivity 를 실행한다.
                val intent = Intent(context, QuizLockerActivity::class.java)
                // 새로운 Activity 로 실행
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                // 기존의 Activity 스택을 제거
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context?.startActivity(intent)
            }
        }
    }
}