package edu.rockvalleycollege.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPage2 = findViewById<Button>(R.id.btnPage2)
        val txtSend = findViewById<EditText>(R.id.txtSend)

        btnPage2.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, Main2Activity::class.java)

            intent.putExtra("Intent Data One",txtSend.text.toString())

            startActivity(intent)

        })


        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }

    }


    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}