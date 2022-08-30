package com.example.wordlegamecodepathkotlin

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }
        var firstguess = true
        if (firstguess) {
            findViewById<Button>(R.id.btnCheck).setOnClickListener {
                Log.i("Main ", "a $wordToGuess")
                firstguess = false
                val etInputWord: EditText = findViewById(R.id.etEnteredWord)
                val inputWord = etInputWord.text.toString()
                val input1: TextView = findViewById(R.id.tvFirstGuessed)
                val status1: TextView = findViewById(R.id.tvFirstStatus)
                val check1: TextView = findViewById(R.id.tvFirstCheck)
                val statuscheck1: TextView = findViewById(R.id.tvFirstStatusCheck)
                input1.text = inputWord.uppercase()
                input1.isVisible = true
                status1.isVisible = true
                check1.isVisible = true
                statuscheck1.isVisible = true
                etInputWord.setText("")
                etInputWord.hideKeyboard()
                check1.text = checkGuess(inputWord.uppercase())
                if (inputWord == wordToGuess){

                }
                findViewById<Button>(R.id.btnCheck).setOnClickListener {
                    var etInputWord1: EditText = findViewById(R.id.etEnteredWord)
                    var inputWord1 = etInputWord1.text.toString()
                    var input2: TextView = findViewById(R.id.tvSecondGuessed)
                    var check2: TextView = findViewById(R.id.tvSecondCheck)
                    input2.text = inputWord1.uppercase()
                    input2.isVisible = true
                    var status2: TextView = findViewById(R.id.tvSecondStatus)
                    status2.isVisible = true
                    check2.text = checkGuess(inputWord1.uppercase())
                    check2.isVisible = true
                    var statuscheck2: TextView = findViewById(R.id.tvSecondStatusCheck)
                    statuscheck2.isVisible = true
                    etInputWord.setText("")
                    etInputWord.hideKeyboard()
                    findViewById<Button>(R.id.btnCheck).setOnClickListener {
                        var etInputWord: EditText = findViewById(R.id.etEnteredWord)
                        var inputWord = etInputWord.text.toString()
                        var input3: TextView = findViewById(R.id.tvThirdGuessed)
                        var check3: TextView = findViewById(R.id.tvThirdCheck)
                        input3.text = inputWord.uppercase()
                        input3.isVisible = true
                        var status3: TextView = findViewById(R.id.tvThirdStatus)
                        status3.isVisible = true
                        check3.text = checkGuess(inputWord.uppercase())
                        check3.isVisible = true
                        var statuscheck3: TextView = findViewById(R.id.tvThirdStatusCheck)
                        statuscheck3.isVisible = true
                        var actualword: TextView = findViewById(R.id.tvCorrectAns)
                        actualword.text = wordToGuess
                        actualword.isVisible = true
                        etInputWord.setText("")
                        etInputWord.hideKeyboard()
                        findViewById<Button>(R.id.btnCheck).setOnClickListener {
                            var btn: Button = findViewById(R.id.btnCheck)
                            btn.isEnabled = false
                            etInputWord.isEnabled= false
                        }
                      }
                    }
                }

            }
        }


    }
    private var wordToGuess = FourLetterWordList.getRandomFourLetterWord()

private fun checkGuess(guess: String): String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            } else if (guess[i] in wordToGuess) {
                result += "+"
            } else {
                result += "X"
            }
        }
        return result
    }

