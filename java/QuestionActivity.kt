package com.example.timestables2

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        var numbersAsked = mutableListOf<Int>()

        var num = 0

        var correct = 0

        var incorrect = 0

        val seconds: Long = this.intent.extras!!.get("time") as Long
        println(seconds)


        //creates timer at the top of the screen
        val clock = object : CountDownTimer(seconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes: Long = millisUntilFinished / 1000 / 60
                val seconds: Long = millisUntilFinished / 1000 % 60
                timerText.text = "$minutes:$seconds"
            }


            override fun onFinish() {
                println("finish")

                //moves to next activity
                val moveToFinish = Intent(applicationContext, FinishedActivity::class.java)
                moveToFinish.putExtra("incorrectNum", incorrect)
                moveToFinish.putExtra("correctNum", correct)
                startActivity(moveToFinish)


            }

        }
        clock.start()

        var rnd1 = 0

//        var correct = 0

        fun numbers(num1: Int, num2: Int){
            questionText.text = "$num1 * $num2"
            val answer = num1 * num2
            answerText.text = answer.toString()
        }

        val numberSelected = this.intent.extras?.get("timesNumber")
        println(numberSelected)

        //sets the number to the number selected, unless all was chosen, in which case it will randomly pick a number
        numberSelected?.let {
            rnd1 = (if (numberSelected == 13) {
                (1..12).random()
            } else numberSelected as Int)
        }

        //if every single number is asked, the list of numbers asked is cleared
        if (numbersAsked.size == 12){
            numbersAsked = mutableListOf<Int>()
        }

        num = (1..12).random()
//        var rnd2 = 0

        //checks if the number has already been asked, if it has the number will be skipped, if not it will be asked
        var found = false

        for (n in numbersAsked) {
            if (n == num) {
                found = true
                break
            }
        }

        while (found) {
            found = false
            num = (1..12).random()
            for (n in numbersAsked) {
                if (n == num) {
                    found = true
                    break
                }
            }
        }
        val rnd2 = num
        numbersAsked.add(rnd2)


        numbers(rnd1,rnd2)

        val yButton = findViewById<Button>(R.id.yesButton)
        yButton.setOnClickListener {


            val numberSelected = this.intent.extras?.get("timesNumber")

            numberSelected?.let {
                rnd1 = if (numberSelected == 13) {
                    (1..12).random()
                } else {
                    numberSelected as Int
                }
            }
//            var rnd1 = (1..12).random()

            if (numbersAsked.size == 12){
                numbersAsked = mutableListOf<Int>()
            }

            num = (1..12).random()

            var found = false

            for (n in numbersAsked) {
                if (n == num) {
                    found = true
                    break
                }
            }

            while (found) {
                found = false
                num = (1..12).random()
                for (n in numbersAsked) {
                    if (n == num) {
                        found = true
                        break
                    }
                }
            }

            val rnd2 = num
            numbersAsked.add(rnd2)

//            }

            numbers(rnd1,rnd2)

            correct += 1
        }

        val nButton = findViewById<Button>(R.id.noButton)
        nButton.setOnClickListener {

            val numberSelected = this.intent.extras?.get("timesNumber")
            numberSelected?.let {
                rnd1 = if (numberSelected == 13) {
                    (1..12).random()
                } else {
                    numberSelected as Int
                }
            }

            if (numbersAsked.size == 12) {
                numbersAsked.clear()
            }

            num = (1..12).random()

            var found = false

            for (n in numbersAsked) {
                if (n == num) {
                    found = true
                    break
                }
            }

            while (found) {
                found = false
                num = (1..12).random()
                for (n in numbersAsked) {
                    if (n == num) {
                        found = true
                        break
                    }
                }
            }
//            if (found) {
////                println("$toFind is found.")
//            }else{
//                println("$num is not found.")
            val rnd2 = num
            numbersAsked.add(rnd2)

//            }

//            var rnd2 = (1..12).random()

            numbers(rnd1,rnd2)
            incorrect += 1
        }

    }
}