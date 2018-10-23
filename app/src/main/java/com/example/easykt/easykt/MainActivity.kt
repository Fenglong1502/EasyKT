package com.example.easykt.easykt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
