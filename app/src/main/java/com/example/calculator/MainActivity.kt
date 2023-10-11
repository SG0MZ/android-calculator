package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        viewModel.result.observe(this,Observer<String> {stringResult -> result.setText(stringResult)})
        viewModel.newNumber.observe(this,Observer<String> {stringNumber -> newNumber.setText(stringNumber)})
        viewModel.operation.observe(this,Observer<String> {stringOperation -> operation.text = stringOperation})

//        Data input buttons
        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonDot: Button = findViewById(R.id.buttonDot)

//        Operation buttons
        val buttonEqual = findViewById<Button>(R.id.buttonEqual)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        val buttonNeg = findViewById<Button>(R.id.buttonNeg)

        val listener = View.OnClickListener { v ->
            viewModel.digitPressed(v as Button).text.toString()
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            viewModel.operandPressed((v as Button).text.toString()
        }

        buttonEqual.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)

        buttonNeg.setOnClickListener({
            viewModel.negPressed()
        })
    }
}