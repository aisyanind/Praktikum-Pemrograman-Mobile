package com.example.modul2mobile
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_dadu)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()} }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val rollResult1 = dice1.roll()
        val rollResult2 = dice2.roll()

        val diceImage1: ImageView = findViewById(R.id.imageViewLeft)
        val diceImage2: ImageView = findViewById(R.id.imageViewRight)
        val drawableResource1 = when (rollResult1) {
            1 -> R.drawable.dadu1
            2 -> R.drawable.dadu2
            3 -> R.drawable.dadu3
            4 -> R.drawable.dadu4
            5 -> R.drawable.dadu5
            else -> R.drawable.dadu6 }
        val drawableResource2 = when (rollResult2) {
            1 -> R.drawable.dadu1
            2 -> R.drawable.dadu2
            3 -> R.drawable.dadu3
            4 -> R.drawable.dadu4
            5 -> R.drawable.dadu5
            else -> R.drawable.dadu6 }

        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = rollResult1.toString()
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = rollResult2.toString()

        val messageTextView: TextView = findViewById(R.id.messageTextView)
        if (rollResult1 != rollResult2) {
            messageTextView.visibility = TextView.VISIBLE
            messageTextView.text = "Anda belum beruntung!" }
        else {
            messageTextView.visibility = TextView.VISIBLE
            messageTextView.text = "Selamat anda mendapatkan dadu double!"
        }
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}