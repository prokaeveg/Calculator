package com.rem.ioscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.String
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.io.Console
import java.lang.ProcessBuilder.Redirect.to

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var txtInput: TextView
    var lastNumeric: Boolean = false
    var stateError: Boolean = false
    var lastDot: Boolean = false
    var currentVal: Int = 0
    var currentTotal: Int = 0
    var newVal: Boolean = false
    var sCurrentOperator: kotlin.String = ""
    var sNewOperator: kotlin.String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.textView)
        txtInput.text = currentVal.toString()

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener(this)
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener(this)
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener(this)
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener(this)
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener(this)
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener(this)
        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener(this)
        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener(this)
        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener(this)
        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener(this)

        val buttonClear: Button = findViewById(R.id.button_clear)
        buttonClear.setOnClickListener(this)
        val buttonSign: Button = findViewById(R.id.button_sign)
        buttonSign.setOnClickListener(this)
        val buttonPercent: Button = findViewById(R.id.button_percent)
        buttonPercent.setOnClickListener(this)
        val buttonSlash: Button = findViewById(R.id.button_slash)
        buttonSlash.setOnClickListener(this)
        val buttonStar: Button = findViewById(R.id.button_star)
        buttonStar.setOnClickListener(this)
        val buttonMinus: Button = findViewById(R.id.button_minus)
        buttonMinus.setOnClickListener(this)
        val buttonPlus: Button = findViewById(R.id.button_plus)
        buttonPlus.setOnClickListener(this)
        val buttonEquals: Button = findViewById(R.id.button_equals)
        buttonEquals.setOnClickListener(this)
        val buttonDot: Button = findViewById(R.id.button_dot)
        buttonDot.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.button0->{
                onDigit(p0)
            }R.id.button1->{
                onDigit(p0)
            }R.id.button2->{
                onDigit(p0)
            }R.id.button3->{
                onDigit(p0)
            }R.id.button4->{
                onDigit(p0)
            }R.id.button5->{
                onDigit(p0)
            }R.id.button6->{
                onDigit(p0)
            }R.id.button7->{
                onDigit(p0)
            }R.id.button8->{
                onDigit(p0)
            }R.id.button9->{
                onDigit(p0)
            }R.id.button_clear->{
                onClear(p0)
            }R.id.button_sign->{
                onToggle(p0)
            }R.id.button_percent->{
                onPercent(p0)
            }R.id.button_slash->{
                onOperator(p0)
            }R.id.button_star->{
                onOperator(p0)
            }R.id.button_minus->{
                onOperator(p0)
            }R.id.button_plus->{
                onOperator(p0)
            }R.id.button_equals->{
                onEqual(p0)
            }R.id.button_dot->{
                onDecimalPoint(p0)
            }

        }


    }

    fun onDigit(view: View) {
        if (stateError) {
            txtInput.text = (view as Button).text
            stateError = false
        } else if (newVal) {
            txtInput.text = (view as Button).text
            newVal = false
        } else if (txtInput.text == "0") {
            txtInput.text = ((view as Button).text)
        } else txtInput.append((view as Button).text)

        if (stateError) {
            txtInput.text = (view as Button).text
            stateError = false
            lastNumeric = true
        }
    }

    fun onDecimalPoint(view: View) {
        if (!stateError && !lastDot) {
            txtInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
            sCurrentOperator = (view as Button).text.toString()
            var number = txtInput.text.toString()

            currentTotal = number.toInt()
            newVal = true
            lastDot = false
    }

    fun onClear(view: View) {
        currentVal = 0
        newVal = true
        this.txtInput.text = currentVal.toString()
        stateError = false
        lastDot = false

    }

    fun onEqual(view: View) {

        if (sCurrentOperator == "")
        else  {
            val display = txtInput.text.toString()
            currentVal = display.toInt()
            println(currentTotal)
            println(currentVal)
        }

        when (sCurrentOperator){
            "/" -> {
                currentTotal /= currentVal
            }
            "*" -> {
                currentTotal *= currentVal
            }
            "+" -> {
                currentTotal += currentVal
            }
            "-" -> {
                currentTotal -= currentVal
            }
        }
        txtInput.text = currentTotal.toString()
        sCurrentOperator = ""
        newVal = true

    }

    fun onPercent(view: View){
        var number = txtInput.text.toString()
        var percent = number.toInt()/100
        txtInput.text = percent.toString()

        currentTotal = percent
    }

    fun onToggle(view: View){
        var number = txtInput.text.toString()
        var negative = number.toInt() * -1
        txtInput.text = negative.toString()

    }
}