package com.example.mobappslab_app1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.ranges.random

class RockPaperScissorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rock_paper_scissors)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var userChoice = ""
        val rockButton = findViewById<TextView>(R.id.rock_button)
        val paperButton = findViewById<TextView>(R.id.paper_button)
        val scissorsButton = findViewById<TextView>(R.id.scissors_button)
        val resultTextView = findViewById<TextView>(R.id.textView)

        rockButton.setOnClickListener {
            userChoice = "Rock"
            runGame(userChoice, resultTextView)
        }

        paperButton.setOnClickListener {
            userChoice = "Paper"
            runGame(userChoice, resultTextView)
        }

        scissorsButton.setOnClickListener {
            userChoice = "Scissors"
            runGame(userChoice, resultTextView)
        }



    }

    fun runGame(userChoice: String, resultTextView: TextView) {
        val computerChoice = randomChoice()
        val result = checkResult(computerChoice, userChoice)
        resultTextView.text = result


    }

    fun checkResult(computerChoice: String, userChoice: String): String {
        var result = ""
        if (computerChoice == "Rock") {
            if (userChoice == "Rock") {
                result = "Rock against Rock! It's a tie!"
            } else if (userChoice == "Paper") {
                result = "Rock against Paper! You win!"
            } else {
                result = "Rock against Scissors! You lose!"
            }
        } else if (computerChoice == "Paper") {
            if (userChoice == "Rock") {
                result = "Paper against Rock! You lose!"
            } else if (userChoice == "Paper") {
                result = "Paper against Paper! It's a tie!"
            } else {
                result = "Paper against Scissors! You win!"
            }
        } else {
            if (userChoice == "Rock") {
                result = "Scissors against Rock! You win!"
            } else if (userChoice == "Paper") {
                result = "Scissors against Paper! You lose!"
            } else {
                result = "Scissors against Scissors! It's a tie!"
            }
        }
        return result
    }

    fun randomChoice(): String {
        var randomNum = (1..3).random()
        var computerChoice = ""
        when (randomNum) {
            1 -> computerChoice = "Rock"
            2 -> computerChoice = "Paper"
            3 -> computerChoice = "Scissors"
        }

        return computerChoice
    }

}