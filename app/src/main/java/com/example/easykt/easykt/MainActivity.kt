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

        val imgBtnTutorial = findViewById<ImageButton>(R.id.imgBtnTutorial)
        imgBtnTutorial.setOnClickListener{
            val intent = Intent(this, ActivityTutorial :: class.java)
            startActivity(intent)
        }
    }
}
