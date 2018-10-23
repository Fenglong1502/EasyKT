package com.example.easykt.easykt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView

class mctestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mctest)

        val quizCard = findViewById<CardView>(R.id.quizCard)
        quizCard.setOnClickListener {
            val myIntent = Intent(this, ActivitQuiz::class.java)
            startActivity(myIntent)
        }

        val tutorialCard = findViewById<CardView>(R.id.tutorialCard)
        tutorialCard.setOnClickListener {
            val myIntent = Intent(this, ActivityTutorial::class.java)
            startActivity(myIntent)
        }

        val videoCard = findViewById<CardView>(R.id.videoCard)
        videoCard.setOnClickListener {
            val myIntent = Intent(this, ActivityVideo::class.java)
            startActivity(myIntent)
        }
    }
}
