package com.toute.quizlocker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.toute.quizlocker.databinding.ActivityPrefFragmentBinding

class PrefFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pref_fragment)
        val binding = ActivityPrefFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction().replace(android.R.id.content, MyPrefFragment()).commit()
        fragmentManager.beginTransaction().replace(android.R.id.content,
            PrefExActivity.MyPrefFragment()
        ).commit()
    }
}