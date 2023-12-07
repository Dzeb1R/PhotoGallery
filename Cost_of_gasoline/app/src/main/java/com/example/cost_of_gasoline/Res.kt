package com.example.cost_of_gasoline

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val ANSWER_SHOWN = "com.bignerdranch.android.example.cost_of_gasoline.answer_shown"
class Res : AppCompatActivity() {
    private var res = "0"
    private lateinit var answer: TextView
    private lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)
        res = intent.getStringExtra(ANSWER_SHOWN).toString()
        answer = findViewById(R.id.answer)
        answer.text = res
        back = findViewById(R.id.back_button)
        back.setOnClickListener {
            finish()
        }
    }
    companion object {
        fun newIntent(packageContext: Context, res: String): Intent {
            return Intent(packageContext, Result::class.java).apply {
                putExtra(ANSWER_SHOWN, res)
            }
        }
    }
}