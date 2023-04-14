package com.example.simplecalculator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var buttonAC: android.widget.Button
    lateinit var buttonC: android.widget.Button
    lateinit var buttondot: android.widget.Button
    lateinit var buttondivide: android.widget.Button
    lateinit var buttonminus: android.widget.Button
    lateinit var buttonplus: android.widget.Button
    lateinit var buttonequals: android.widget.Button
    lateinit var buttonmultiply: android.widget.Button
    lateinit var buttonmodulus: android.widget.Button
    lateinit var buttonmemoryadd: android.widget.Button
    lateinit var buttonmemoryclear: android.widget.Button
    lateinit var buttonmemoryrecall: android.widget.Button
    lateinit var inputex: EditText
    lateinit var resultex: EditText

    var check = 0
    var memory: Float = 0f
    var memoryrecall: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        button0 = findViewById(R.id.bu0)
        button1 = findViewById(R.id.bu1)
        button2 = findViewById(R.id.bu2)
        button3 = findViewById(R.id.bu3)
        button4 = findViewById(R.id.bu4)
        button5 = findViewById(R.id.bu5)
        button6 = findViewById(R.id.bu6)
        button7 = findViewById(R.id.bu7)
        button8 = findViewById(R.id.bu8)
        button9 = findViewById(R.id.bu9)
        buttonAC = findViewById(R.id.buAC)
        buttonC = findViewById(R.id.buC)
        buttondot = findViewById(R.id.budot)
        buttondivide = findViewById(R.id.buDivide)
        buttonminus = findViewById(R.id.buminus)
        buttonplus = findViewById(R.id.buplus)
        buttonequals = findViewById(R.id.buequals)
        buttonmultiply = findViewById(R.id.buMultiply)
        buttonmodulus = findViewById(R.id.bumodulus)
        buttonmemoryadd = findViewById(R.id.bumemoryadd)
        buttonmemoryclear = findViewById(R.id.bumemoryclear)
        buttonmemoryrecall = findViewById(R.id.bumemoryrecall)
        resultex = findViewById(R.id.editText1)
        inputex = findViewById(R.id.editText)
        inputex.movementMethod = ScrollingMovementMethod()
        inputex.setActivated(true)
        inputex.setPressed(true)

        var text: String

        button1.setOnClickListener {
            text = inputex.text.toString() + "1"
            inputex.setText(text)
            result(text)
        }
        button2.setOnClickListener {
            text = inputex.text.toString() + "2"
            inputex.setText(text)
            result(text)
        }
        button3.setOnClickListener {
            text = inputex.text.toString() + "3"
            inputex.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text = inputex.text.toString() + "4"
            inputex.setText(text)
            result(text)
        }
        button5.setOnClickListener {
            text = inputex.text.toString() + "5"
            inputex.setText(text)
            result(text)
        }
        button6.setOnClickListener {
            text = inputex.text.toString() + "6"
            inputex.setText(text)
            result(text)
        }
        button7.setOnClickListener {
            text = inputex.text.toString() + "7"
            inputex.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text = inputex.text.toString() + "8"
            inputex.setText(text)
            result(text)
        }
        button9.setOnClickListener {
            text = inputex.text.toString() + "9"
            inputex.setText(text)
            result(text)
        }
        button0.setOnClickListener {
            text = inputex.text.toString() + "0"
            inputex.setText(text)
            result(text)
        }
        buttondot.setOnClickListener {
            text = inputex.text.toString() + "."
            inputex.setText(text)
            result(text)
        }

        buttonplus.setOnClickListener {
            text = inputex.text.toString() + "+"
            inputex.setText(text)
            check = check + 1
        }
        buttonminus.setOnClickListener {
            text = inputex.text.toString() + "-"
            inputex.setText(text)
            check = check + 1
        }
        buttonmultiply.setOnClickListener {
            text = inputex.text.toString() + "*"
            inputex.setText(text)
            check = check + 1
        }
        buttondivide.setOnClickListener {
            text = inputex.text.toString() + "/"
            inputex.setText(text)
            check = check + 1
        }
        buttonmodulus.setOnClickListener {
            text = inputex.text.toString() + "%"
            inputex.setText(text)
            check = check + 1
        }
        buttonequals.setOnClickListener {
            text = resultex.text.toString()
            inputex.setText(text)
            resultex.setText(null)
        }
        buttonAC.setOnClickListener {
            inputex.setText(null)
            resultex.setText(null)
        }
        var memory: Double = 0.0

        buttonmemoryrecall.isEnabled = false

        buttonmemoryadd.setOnClickListener {
            text = inputex.text.toString()
            if (text.isNotEmpty()) {
                val resultValue = text.toDouble()
                memory += resultValue
                buttonmemoryrecall.isEnabled = true
                Toast.makeText(this, "Result added to memory", Toast.LENGTH_SHORT).show()
            }
        }
        buttonmemoryrecall.setOnClickListener {
            if (memory != null) {
                text = inputex.text.toString() + memory
                inputex.setText(text)
                result(text)
            } else {
                Toast.makeText(this, "The memory is empty", Toast.LENGTH_SHORT).show()
            }
        }
        buttonmemoryclear.setOnClickListener {
            memory = 0.0
            buttonmemoryrecall.isEnabled = false
        }
        buttonC.setOnClickListener {

            val backSpace: String?
            if (inputex.text.isNotEmpty()) {
                val stringBuilder: java.lang.StringBuilder = StringBuilder(inputex.text)
                val find = inputex.text.toString()
                val find2 = find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals(
                        '%'
                    )
                ) {
                    check = check - 1
                }

                stringBuilder.deleteCharAt(inputex.text.length - 1)
                backSpace = stringBuilder.toString()
                inputex.setText(backSpace)
                result(backSpace)
            }

        }

    }

    private fun result(text: String) {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            val mainResult = result.toString()
            if (check == 0) {
                resultex.setText(null)
            } else {
                resultex.setText(mainResult)
            }
        } catch (e: ScriptException) {
            Log.d("TAG", "ERROR")
        }

    }
}
