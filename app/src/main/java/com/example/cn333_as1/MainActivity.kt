package com.example.cn333_as1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var textViewWrong: TextView
    lateinit var textViewShow: TextView
    lateinit var editText: EditText
    lateinit var buttonGuess: Button
    lateinit var imageButtonreset: ImageButton
    lateinit var winningshow: TextView
    lateinit var winningshowfail: TextView
    lateinit var shownumber: TextView
    lateinit var shownumberint: TextView
    lateinit var showcongrat: TextView
    var Count_wrong: Int = 0
    var random: Int = nextInt(1,1000)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        textViewShow = findViewById(R.id.WrongCount)
        textViewWrong = findViewById(R.id.WrongCountShow)
        editText = findViewById(R.id.editText)
        buttonGuess = findViewById(R.id.ButtonGuess)
        imageButtonreset = findViewById(R.id.imageButtonReset)
        winningshow = findViewById(R.id.failcount)
        winningshowfail = findViewById(R.id.failcountnumber)
        shownumber = findViewById(R.id.shownumber)
        shownumberint= findViewById(R.id.shownumberint)
        showcongrat = findViewById(R.id.congrat)
        textView.text = "Enter your number"

        buttonGuess.setOnClickListener{
            val number:Int = editText.text.toString().toInt()
            if(number < random){
                textView.text = "WRONG < TOO LOW"
                Count_wrong = Count_wrong+1
                textViewWrong.text = Count_wrong.toString()
            }
            else if (number> random){
                textView.text = "WRONG > TOO HIGH"
                Count_wrong = Count_wrong+1
                textViewWrong.text = Count_wrong.toString()
            }
            else{
                textViewShow.visibility = View.INVISIBLE
                textViewWrong.visibility = View.INVISIBLE
                textView.visibility = View.INVISIBLE
                winningshow.visibility = View.VISIBLE
                showcongrat.visibility = View.VISIBLE
                winningshowfail.text = Count_wrong.toString()
                winningshowfail.visibility = View.VISIBLE
                textViewWrong.text = Count_wrong.toString()
                buttonGuess.visibility = View.INVISIBLE
                editText.visibility = View.INVISIBLE
                shownumber.visibility = View.VISIBLE
                shownumberint.text = random.toString()
                shownumberint.visibility = View.VISIBLE


            }
        }
        imageButtonreset.setOnClickListener{
            reset()
        }
    }
    fun reset(){
        winningshowfail.visibility = View.INVISIBLE
        winningshow.visibility = View.INVISIBLE
        textViewShow.visibility = View.VISIBLE
        textViewWrong.visibility = View.VISIBLE
        buttonGuess.visibility = View.VISIBLE
        editText.visibility = View.VISIBLE
        shownumber.visibility = View.INVISIBLE
        shownumberint.visibility = View.INVISIBLE
        textView.visibility = View.VISIBLE
        showcongrat.visibility = View.INVISIBLE
        Count_wrong = 0
        random = nextInt(1,1000)
        textView.text = "Enter your number"
        textViewWrong.text = Count_wrong.toString()
        editText.text.clear()

    }
}