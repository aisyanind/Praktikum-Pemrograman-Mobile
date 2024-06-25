package com.example.timtime

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCostOfService: EditText = findViewById(R.id.etCostOfService)
        val rgServiceQuality: RadioGroup = findViewById(R.id.rgServiceQuality)
        val swRoundUp: Switch = findViewById(R.id.swRoundUp)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val tvTipAmount: TextView = findViewById(R.id.tvTipAmount)

        btnCalculate.setOnClickListener {
            val cost = etCostOfService.text.toString().toDoubleOrNull()
            if (cost == null) {
                tvTipAmount.text = ""
                Toast.makeText(this, "Please enter a valid cost", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val tipPercentage = when (rgServiceQuality.checkedRadioButtonId) {
                R.id.rbAmazing -> 0.20
                R.id.rbGood -> 0.18
                R.id.rbOkay -> 0.15
                else -> 0.0
            }

            var tip = cost * tipPercentage
            if (swRoundUp.isChecked) {
                tip = ceil(tip)
            }

            tvTipAmount.text = String.format("Tip Amount: \$%.2f", tip)
        }
    }
}