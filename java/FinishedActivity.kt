package com.example.timestables2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_finished.*

class FinishedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)

        //restart button
        val restart = findViewById<Button>(R.id.restartButton)
        restart.setOnClickListener {
            val moveToTables = Intent(this, MainActivity::class.java)
            startActivity(moveToTables)
        }
        //presents all the data about number of correct answers, correct percent, etc.
        val correctSelected: Int = this.intent.extras?.get("correctNum") as Int

        val incorrectSelected: Int = this.intent.extras?.get("incorrectNum") as Int

        correctAnswers.text = "Correct: $correctSelected"

        incorrectAnswers.text = "Incorrect: $incorrectSelected"

        val total = incorrectSelected + correctSelected
        println(total)

        val correctPercent = correctSelected.toFloat() / total.toFloat() * 100
        println(correctPercent)


        correctPercentText.text = "Correct Percent: %.1f".format((correctPercent))

    }
}