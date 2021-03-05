package com.example.timestables2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import io.realm.Realm

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun tables(tablesVar: Int){

            //moves to next activity
            val moveToTime = Intent(this, TimerSelectActivity::class.java)
            moveToTime.putExtra("timesNumber1", tablesVar)
            println(tablesVar)

            startActivity(moveToTime)
        }

        //gets the times table button selection, this will be used later in the QuestionActivity
        val one = findViewById<Button>(R.id.button1)
        one.setOnClickListener {
            tables(1)
        }

        val two = findViewById<Button>(R.id.button2)
        two.setOnClickListener {
            tables(2)
        }
        val three = findViewById<Button>(R.id.button3)
        three.setOnClickListener {
            tables(3)
        }
        val four = findViewById<Button>(R.id.button4)
        four.setOnClickListener {
            tables(4)
        }
        val five = findViewById<Button>(R.id.button5)
        five.setOnClickListener {
            tables(5)
        }
        val six = findViewById<Button>(R.id.button6)
        six.setOnClickListener {
            tables(6)
        }
        val seven = findViewById<Button>(R.id.button7)
        seven.setOnClickListener {
            tables(7)
        }
        val eight = findViewById<Button>(R.id.button8)
        eight.setOnClickListener {
            tables(8)
        }
        val nine = findViewById<Button>(R.id.button9)
        nine.setOnClickListener {
            tables(9)
        }
        val ten = findViewById<Button>(R.id.button10)
        ten.setOnClickListener {
            tables(10)
        }
        val eleven = findViewById<Button>(R.id.button11)
        eleven.setOnClickListener {
            tables(11)
        }
        val twelve = findViewById<Button>(R.id.button12)
        twelve.setOnClickListener {
            tables(12)
        }
        val all = findViewById<Button>(R.id.button13)
        all.setOnClickListener {
            tables(13)
        }


    }
}