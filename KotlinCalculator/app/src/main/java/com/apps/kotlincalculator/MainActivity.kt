package com.apps.kotlincalculator

import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.ClipData

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivision : Button
    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var resultTV : TextView
    lateinit var clipboard: ClipboardManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_subtract)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivision = findViewById(R.id.btn_divide)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTV = findViewById(R.id.result_tv)

        clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var a  = etA.text.toString().toDouble()
        var b  = etB.text.toString().toDouble()
        var result = 0.0
        var inputInString = " "

        when(v?.id){
            R.id.btn_add ->{
                result = a + b;
                inputInString = "$a + $b = "
            }
            R.id.btn_subtract ->{
                result = a - b;
                inputInString = "$a - $b = "
            }
            R.id.btn_multiply ->{
                result = a * b;
                inputInString = "$a * $b = "
            }
            R.id.btn_divide ->{
                result = a / b;
                inputInString = "$a / $b = "
            }
        }
        var clip = ClipData.newPlainText("result is","$result")
        clipboard.setPrimaryClip(clip)

        resultTV.text = "$inputInString $result"


    }
}

