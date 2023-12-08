package com.example.cost_of_gasoline

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "MainActivity"
private const val KEY_INDEX1 = "liters"

class MainActivity : AppCompatActivity() {
    private lateinit var liters_input: EditText
    private lateinit var ok_button: Button
    private lateinit var gasoline92: RadioButton
    private lateinit var gasoline95: RadioButton
    private lateinit var gasoline98: RadioButton
    private var kurs = 50
    private var liters = ""
    private var str = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        liters_input = findViewById(R.id.liters_input)
        ok_button = findViewById(R.id.ok_button)

        gasoline92 = findViewById(R.id.radio92)
        gasoline92.setOnClickListener(radioButtonClickListener)
        gasoline92.isChecked = true

        gasoline95 = findViewById(R.id.radio95)
        gasoline95.setOnClickListener(radioButtonClickListener)

        gasoline98 = findViewById(R.id.radio98)
        gasoline98.setOnClickListener(radioButtonClickListener)

        if (savedInstanceState != null) {
            liters_input.append(savedInstanceState.getString(KEY_INDEX1, ""))
        }

        ok_button.setOnClickListener {
            if (liters_input.text.toString() == "")
            {
                Toast.makeText(this, "Введите количество литров!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                liters = liters_input.text.toString()
                val res = liters.toFloat()*kurs
                str = "Цена за $liters литра(ов) бензина = $res руб."
                val intent = Res.newIntent(this@MainActivity, str)
                startActivity(intent)
            }
        }
    }
    private var radioButtonClickListener = View.OnClickListener { v -> val rb = v as RadioButton
        when (rb.id) {
            gasoline92.id -> {
                kurs = 50
            }
            gasoline95.id -> {
                kurs = 55
            }
            gasoline98.id -> {
                kurs = 57
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle)
    {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putString(KEY_INDEX1, liters)
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }
}