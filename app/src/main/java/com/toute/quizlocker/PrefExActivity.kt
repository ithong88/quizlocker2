package com.toute.quizlocker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceFragment
//import androidx.fragment.app.FragmentActivity
import com.toute.quizlocker.databinding.ActivityFileExBinding
import com.toute.quizlocker.databinding.ActivityPrefExBinding
import com.toute.quizlocker.databinding.ActivityPrefFragmentBinding

class PrefExActivity : AppCompatActivity() {
    // nameField 의 데이터를 저장할 Key
    val nameFieldKey = "nameField"

    // pushCheckBox의 데이터를 저장할 Key
    val pushCheckBoxKey = "pushCheckBox"
    // shared preference 객체, Activity 초기화 이후에 사용해야 하기 때문에 lazy 위임을 사용
    val preference by lazy { getSharedPreferences("PrefExActivity", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // PrefExActivity
        val binding = ActivityPrefExBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_pref_ex)

        // 저장 버튼이 클릭된 경우
        binding.saveButton2.setOnClickListener {
            // SharedPreference 에서 nameFieldKey 키값으로 nameField 의 현재 텍스트를 저장한다.
            preference.edit().putString(nameFieldKey, binding.nameField.text.toString()).apply()

            // SharedPreference 에서 pushCheckBoxKey 키값으로 체크 박스의 현재 체크 상태를 저장한다.
            preference.edit().putBoolean(pushCheckBoxKey, binding.pushCheckBox.isChecked).apply()
        }

        // 불러오기 버튼이 클릭된 경우
        binding.loadButton2.setOnClickListener {
            // SharedPreference 에서 nameFieldKey 로 저장된 문자열을 불러와 nameField 의 텍스트로 설정
            binding.nameField.setText(preference.getString(nameFieldKey, ""))

            // SharedPreference 에서 pushCheckBoxKey 키값으로 불린값을 불러와 pushCheckBox 의 체크상태를 설정
            binding.pushCheckBox.isChecked = preference.getBoolean(pushCheckBoxKey, false)
        }
        // PrefExActivity
    }

    // PreferenceFragment: XML 로 작성한 Preference 를 UI 로 보여주는 클래스
    class MyPrefFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Preference 정보가 있는 XML 파일 지정
            addPreferencesFromResource(R.xml.ex_pref)
        }
    }
}