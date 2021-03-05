package com.example.timestables2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import kotlin.concurrent.timer

class TimerSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_select)

//        var correctSelectedMainInt = 0
        var numberSelectedMainInt = 0

        var numberSelectedMain: Int = this.intent.extras!!.get("timesNumber1") as Int
                println(numberSelectedMain)

        fun timer(seconds: Long) {

//            var time = seconds

            //moves to next activity
            val moveToQuestions = Intent(this, QuestionActivity::class.java)
            moveToQuestions.putExtra("timesNumber", numberSelectedMain)
            moveToQuestions.putExtra("time", seconds)
            println(seconds)
            startActivity(moveToQuestions)

        }

        //checks whether 1,3, or 5 min timer has been selected, and sets timer to that amount
        val oneMin = findViewById<Button>(R.id.button1m)
        oneMin.setOnClickListener {
            timer(60000)

            return@setOnClickListener

        }

        val threeMin = findViewById<Button>(R.id.button3m)
        threeMin.setOnClickListener {

            timer(180000)
            return@setOnClickListener

        }

        val fiveMin = findViewById<Button>(R.id.button5m)
        fiveMin.setOnClickListener {

            timer(300000)
            return@setOnClickListener

        }
    }
}

