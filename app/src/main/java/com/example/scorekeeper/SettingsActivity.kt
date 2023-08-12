package com.example.scorekeeper

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val score = sharedPreferences!!.getBoolean("saveScore", false)
        val checkBox = findViewById<CheckBox>(R.id.checkbox_save)
        checkBox.isChecked = score;



        findViewById<CheckBox>(R.id.checkbox_save)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                val sharedPreferences = getPreferences(MODE_PRIVATE)
                if (isChecked) {
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("saveScore", true)
                    editor.commit()

                } else {
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("saveScore", false)
                    editor.commit()
                }
            }

    }

    fun onGoBackClicked(v: View?) {
        finish();
//        val intent = Intent(this@CreateContactsActivity, MainActivity::class.java)
//        startActivity(intent);
    }
}