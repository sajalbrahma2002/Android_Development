package com.example.dicegame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView2)
        textView = findViewById(R.id.textView)
        rollButton = findViewById(R.id.rollButton)

        rollButton.setOnClickListener{
            val randomNumber = (1..6).random()
            updateImageView(randomNumber)
            textView.text = randomNumber.toString()
            Toast.makeText(this, "Number: $randomNumber",Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateImageView(number: Int){
        val resourceId = when(number){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageView.setImageResource(resourceId)
    }
}
