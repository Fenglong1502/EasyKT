package com.example.easykt.easykt

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.my_toolbar))

        context = this

        val quizCard = findViewById<CardView>(R.id.quizCard)
        quizCard.setOnClickListener {
            val myIntent = Intent(this, ActivityDisplay::class.java)
            myIntent.putExtra("FragmentToPass", "quiz")
            startActivity(myIntent)
        }

        val tutorialCard = findViewById<CardView>(R.id.tutorialCard)
        tutorialCard.setOnClickListener {
            val myIntent = Intent(this, ActivityDisplay::class.java)
            myIntent.putExtra("FragmentToPass", "tutorial")
            startActivity(myIntent)
        }

        val videoCard = findViewById<CardView>(R.id.videoCard)
        videoCard.setOnClickListener {
            val myIntent = Intent(this, ActivityDisplay::class.java)
            myIntent.putExtra("FragmentToPass", "video")
            startActivity(myIntent)
        }
    }

    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Are you sure !")
        dialog.setMessage("Do you want to quit EasyKT?")
        dialog.setPositiveButton("Yes") { dialog, which ->
            dialog?.dismiss()
            super.onBackPressed()
        }
        dialog.setNegativeButton("No") { dialog, which -> dialog?.dismiss() }
        dialog.show()
    }
}
